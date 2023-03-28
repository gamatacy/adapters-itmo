package com.gamatacy.backend.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.*

@Entity
data class EventEntity(
    @Id
    val id: Long? = null,
    val name: String? = null,
    val description: String? = null,
    val date: Date? = null,
    val visitors: String? = null
)
