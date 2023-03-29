package com.gamatacy.backend.entity

import com.gamatacy.enum.UserRole
import jakarta.persistence.*

@Entity
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    var username: String? = null,
    var isuNumber: Int? = null,
    var firstName: String? = null,
    var middleName: String? = null,
    var lastName: String? = null,
    var password: String? = null,
    var email: String? = null,

    @ElementCollection(targetClass = UserRole::class, fetch = FetchType.EAGER)
    @CollectionTable(name = "userRoles")
    @Enumerated(EnumType.STRING)
    var role: Set<UserRole>? = null,
    var avatar: String? = null
)
