package com.gamatacy.backend.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class TestResultEntity(
    @Id
    val id: Long? = null,
    val userId: Long? = null,
    val testId: Long? = null,
    val answers: String? = null
)