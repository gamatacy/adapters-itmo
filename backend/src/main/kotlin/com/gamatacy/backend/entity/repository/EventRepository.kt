package com.gamatacy.backend.entity.repository

import com.gamatacy.backend.entity.EventEntity
import org.springframework.data.repository.CrudRepository

interface EventRepository: CrudRepository<EventEntity, Long> {
}