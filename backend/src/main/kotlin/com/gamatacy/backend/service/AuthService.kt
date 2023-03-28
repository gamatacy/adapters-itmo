package com.gamatacy.backend.service

import com.gamatacy.backend.dto.RegistrationUserDto
import com.gamatacy.backend.entity.UserEntity
import com.gamatacy.backend.entity.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseCookie
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class AuthenticationService {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var jwtService: JwtService

    fun register(user: RegistrationUserDto): ResponseEntity<Any> {

        if (userRepository.findByUsername(user.username) != null) {
            return ResponseEntity.status(403).body(FailedAuthenticationResponseDto("Account with this username already exist"))
        }

        val userEntity = UserEntity()

        val accessToken = jwtService.generateAccessToken(user.username)
        val refreshToken = jwtService.generateRefreshToken(user.username)
        val cookie =
            ResponseCookie.from("refreshToken", refreshToken)
                .httpOnly(true)
                .path("/api/auth/refresh")
                .maxAge(60 * 60 * 24 * 7)
                .build()

        return try {
            userRepository.save(userEntity)
            ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(AuthenticationResponseDto(accessToken))
        } catch (e: Exception) {
            ResponseEntity.status(403).body(FailedAuthenticationResponseDto("Server side problems"))
        }
    }

    fun login(user: LoginUserDto): ResponseEntity<Any> {

        val userEntity = userRepository.findByUsername(user.username)
            ?: return ResponseEntity.status(403).body(FailedAuthenticationResponseDto("Account with this username doesn't exist"))

        val accessToken = jwtService.generateAccessToken(user.username)
        val refreshToken = jwtService.generateRefreshToken(user.username)
        val cookie =
            ResponseCookie.from("refreshToken", refreshToken)
                .path("/api/auth/refresh")
                .httpOnly(true)
                .maxAge(60 * 60 * 24 * 7)
                .build()

        return if (userEntity.password.equals(PasswordEncoder.encodePassword(user.password))) {
            ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(AuthenticationResponseDto(accessToken))
        } else {
            ResponseEntity.status(403).body(FailedAuthenticationResponseDto("Wrong password"))
        }

    }

    fun refreshToken(request: HttpServletRequest): ResponseEntity<Any> {
        val oldCookie = WebUtils.getCookie(request, "refreshToken")?.value
        if (oldCookie != null && jwtService.validateToken(oldCookie)) {
            val cookie =
                ResponseCookie.from("refreshToken", jwtService.generateRefreshToken(jwtService.getUsername(oldCookie)))
                    .path("/api/auth/refresh")
                    .httpOnly(true)
                    .maxAge(60 * 60 * 24 * 7)
                    .build()
            return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(AuthenticationResponseDto(jwtService.generateAccessToken(jwtService.getUsername(oldCookie))))
        }

        return ResponseEntity.status(403).body("Token Expired")

    }

    fun logout(request: HttpServletRequest): ResponseEntity<Any>{
        val cookie =
            ResponseCookie.from("refreshToken", "")
                .path("/api/auth/refresh")
                .httpOnly(true)
                .maxAge(0)
                .build()
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body(OkResponse("logout success"))
    }

}
