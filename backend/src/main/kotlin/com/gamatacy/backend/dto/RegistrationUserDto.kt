package com.gamatacy.backend.dto

data class RegistrationUserDto(
    val username: String,
    val isuNumber: Int,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val password: String,
    val email: String,
    val avatar: String
)