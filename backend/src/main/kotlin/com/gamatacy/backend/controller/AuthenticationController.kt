package com.gamatacy.backend.controller

import com.gamatacy.backend.dto.LoginUserDto
import com.gamatacy.backend.dto.RegistrationUserDto
import com.gamatacy.backend.service.AuthenticationService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("api/auth")
class AuthenticationController {

    @Autowired
    private lateinit var authService: AuthenticationService

    @PostMapping("/registration")
    fun registration(@RequestBody user: RegistrationUserDto): ResponseEntity<Any> {
        return authService.register(user)
    }

    @PostMapping("/login")
    fun login(@RequestBody user: LoginUserDto): ResponseEntity<Any> {
        return authService.login(user)
    }


    @GetMapping("/refresh")
    fun refresh(request: HttpServletRequest): ResponseEntity<Any>{
        return authService.refreshToken(request)
    }

    @GetMapping("/logout")
    fun logout(request: HttpServletRequest): ResponseEntity<Any>{
        return authService.logout(request)
    }

}