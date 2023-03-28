package com.gamatacy.backend.service

import com.gamatacy.entity.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService: UserDetailsService {

    @Autowired
    private lateinit var userRepository: UserRepository

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userRepository.findByUsername(username.toString())
        val grantedAuthorities: MutableCollection<GrantedAuthority> = mutableListOf()
        return User(user?.username, user?.password,
            user?.role?.mapTo(grantedAuthorities) { SimpleGrantedAuthority(it.toString()) }
            )
    }

}