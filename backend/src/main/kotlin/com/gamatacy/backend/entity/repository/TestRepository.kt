package com.gamatacy.backend.entity.repository

import com.gamatacy.backend.entity.TestEntity
import org.springframework.data.repository.CrudRepository

interface TestRepository: CrudRepository<TestEntity, Long> {
}