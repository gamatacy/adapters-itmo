package com.gamatacy.backend.entity.repository

import com.gamatacy.backend.entity.UserEntity
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<UserEntity, Long> {
    fun findByUsername(username: String): UserEntity?
}