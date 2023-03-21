package com.gamatacy.entity.repository

import com.gamatacy.entity.UserEntity
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<UserEntity, Long> {

}