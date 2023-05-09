package com.gamatacy.backend.entity

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.sql.Date
import java.time.YearMonth

@Entity
data class EventEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    val name: String? = null,
    val description: String? = null,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    val date: Date? = null,
    val visitors: String? = null
){
    fun getYear(): Int {
        return YearMonth.from(date?.toLocalDate()).year
    }

    fun getMonth(): Int {
        return YearMonth.from(date?.toLocalDate()).monthValue
    }
}
