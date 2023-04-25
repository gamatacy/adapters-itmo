package com.gamatacy.backend.service;

import com.gamatacy.backend.dto.FailedAuthenticationResponseDto
import com.gamatacy.backend.dto.UserInfoDto
import com.gamatacy.backend.entity.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity

@Service
class UserDataService {

    @Autowired
    private lateinit var userRepository: UserRepository

    fun getUser(username: String): ResponseEntity<Any> {
        val user = userRepository.findByUsername(username)
        return if (user == null) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        } else {
            ResponseEntity.ok().body(
                UserInfoDto(
                    user.username,
                    user.isuNumber,
                    user.firstName,
                    user.middleName,
                    user.lastName,
                    user.email,
                    user.avatar
                )
            )
        }

    }

    fun getUsers(page: Int): ResponseEntity<Any> {
        val users = userRepository.findAll(PageRequest.of(page, 10, Sort.by("middleName")))
        val usersList = mutableListOf<UserInfoDto>()
        users.forEach {
            usersList.add(
                UserInfoDto(
                    it.username,
                    it.isuNumber,
                    it.firstName,
                    it.middleName,
                    it.lastName,
                    it.email,
                    it.avatar
                )
            )
        }
        return ResponseEntity.ok().body(usersList)
    }

}
