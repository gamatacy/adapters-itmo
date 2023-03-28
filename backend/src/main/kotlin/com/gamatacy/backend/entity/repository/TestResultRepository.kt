package com.gamatacy.backend.entity.repository

import com.gamatacy.backend.entity.TestResultEntity
import org.springframework.data.repository.CrudRepository

interface TestResultRepository: CrudRepository<TestResultEntity, Long> {
}