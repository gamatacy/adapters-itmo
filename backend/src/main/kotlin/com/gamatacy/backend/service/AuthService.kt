package com.gamatacy.backend.service

import com.gamatacy.backend.dto.*
import com.gamatacy.backend.entity.UserEntity
import com.gamatacy.backend.entity.repository.UserRepository
import com.gamatacy.enum.UserRole
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseCookie
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.util.WebUtils

@Service
class AuthenticationService {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var jwtService: JwtService

    fun register(user: RegistrationUserDto): ResponseEntity<Any> {

        if (userRepository.findByUsername(user.username) != null) {
            return ResponseEntity.status(403)
                .body(FailedAuthenticationResponseDto("Account with this username already exist"))
        }

        val userEntity = UserEntity()

        userEntity.username = user.username
        userEntity.isuNumber = user.isuNumber
        userEntity.firstName = user.firstName
        userEntity.middleName = user.middleName
        userEntity.lastName = user.lastName
        userEntity.password = user.password
        userEntity.email = user.email
        userEntity.avatar = user.avatar
        userEntity.role = setOf(UserRole.USER)

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
                .body(AuthenticationResponseDto("Successful registration", accessToken))
        } catch (e: Exception) {
            println(e.message)
            ResponseEntity.status(403).body("Server side problems")
        }
    }

    fun login(user: LoginUserDto): ResponseEntity<Any> {

        val userEntity = userRepository.findByUsername(user.username)
            ?: return ResponseEntity.status(403)
                .body(FailedAuthenticationResponseDto("Account with this username doesn't exist"))

        val accessToken = jwtService.generateAccessToken(user.username)
        val refreshToken = jwtService.generateRefreshToken(user.username)
        val cookie =
            ResponseCookie.from("refreshToken", refreshToken)
                .path("/api/auth/refresh")
                .httpOnly(true)
                .maxAge(60 * 60 * 24 * 7)
                .build()

        return if (userEntity.password.equals(user.password)) {
            ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(AuthenticationResponseDto("Logged in", accessToken))
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
                .body(AuthenticationResponseDto("Token refreshed",jwtService.generateAccessToken(jwtService.getUsername(oldCookie))))
        }

        return ResponseEntity.status(403).body("Token Expired")

    }

    fun logout(request: HttpServletRequest): ResponseEntity<Any> {
        val cookie =
            ResponseCookie.from("refreshToken", "")
                .path("/api/auth/refresh")
                .httpOnly(true)
                .maxAge(0)
                .build()
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
            .body("Logged out")
    }

}
