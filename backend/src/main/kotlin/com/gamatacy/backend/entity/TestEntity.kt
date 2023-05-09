package com.gamatacy.backend.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class TestEntity (
    @Id
    val id: Long? = null,
    val name: String? = null,
    val questions: String? = null,
    val answers: String? = null
)