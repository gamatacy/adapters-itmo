package com.gamatacy.backend.entity.repository

import com.gamatacy.backend.entity.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface UserRepository : CrudRepository<UserEntity, Long>, PagingAndSortingRepository<UserEntity, Long> {
    fun findByUsername(username: String): UserEntity?
}