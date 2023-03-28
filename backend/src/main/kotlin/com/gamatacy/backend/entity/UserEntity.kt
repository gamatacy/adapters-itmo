package com.gamatacy.backend.entity

import com.gamatacy.enum.UserRole
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class UserEntity(
    @Id
    val id: Long? = null,
    val username: String? = null,
    val isuNumber: Int? = null,
    val firstName: String? = null,
    val middleName: String? = null,
    val lastName: String? = null,
    val password: String? = null,
    val email: String? = null,
    val role: Set<UserRole>? = null
)
