package com.gamatacy.backend.service

import com.gamatacy.backend.entity.EventEntity
import com.gamatacy.backend.entity.repository.EventRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.sql.*
import java.text.SimpleDateFormat
import java.time.YearMonth

@Service
class EventService {

    @Autowired
    private lateinit var eventRepository: EventRepository

    fun addEvent(event: EventEntity): ResponseEntity<Any> {
        eventRepository.save(event)
        return ResponseEntity.ok("Event added")
    }

    fun getEvent(date: String): ResponseEntity<Any> {
        try {
            val format = SimpleDateFormat("yyyy-MM-dd")
            val date = Date(format.parse(date).time)

            val year = YearMonth.from(date?.toLocalDate()).year
            val month = YearMonth.from(date?.toLocalDate()).monthValue
            val events = eventRepository.findAll()
            val suitEvents = mutableListOf<EventEntity>()

            events.forEach {
                if (it.getYear() == year && it.getMonth() == month) {
                    suitEvents.add(it)
                }
            }

            return ResponseEntity.ok().body(suitEvents)
        } catch (e: Exception) {
            return ResponseEntity.badRequest().body("Wrong date format")
        }
    }

}