package com.gamatacy.backend.service

import com.gamatacy.enum.UserRole
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import jakarta.servlet.http.HttpServletRequest
import java.util.*

@Service
class JwtService {

    @Value("\${jwt.key}")
    lateinit var jwtKey: String

    @Value("\${jwt.expiration}")
    lateinit var expiration: Integer

    @Value("\${jwt.refreshExpiration}")
    lateinit var refreshExpiration: Integer


    fun generateAccessToken(username: String): String{
        return generateToken(username, Date(Date().time + expiration.toLong()))
    }

    fun generateRefreshToken(username: String): String{
        return generateToken(username, Date(Date().time + refreshExpiration.toLong()))
    }

    private fun generateToken(username: String, expirationDate: Date): String{
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(Date())
            .setExpiration(expirationDate)
            .signWith(SignatureAlgorithm.HS256, jwtKey)
            .compact()
    }

    fun validateToken(token: String): Boolean{
        return try {
            Jwts.parser()
                .setSigningKey(jwtKey)
                .parseClaimsJws(token)
            true
        }catch (e: Exception){
            false
        }
    }

    fun parseJwt(request: HttpServletRequest): String {
        return try{
            request.getHeader("Authorization")
        }catch (e: Exception){
            ""
        }
    }

    fun getUsername(token: String): String{
        return Jwts.parser()
            .setSigningKey(jwtKey)
            .parseClaimsJws(token)
            .body
            .subject
    }

}
