package com.gamatacy.backend.controller

import com.gamatacy.backend.entity.EventEntity
import com.gamatacy.backend.service.EventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/events")
class EventController {

    @Autowired
    private lateinit var eventService: EventService

    @PostMapping("/addEvent")
    fun addEvent(@RequestBody event: EventEntity): ResponseEntity<Any> {
        return eventService.addEvent(event)
    }

    @GetMapping("/getEvents/{date}")
    fun getEvent(@PathVariable(value = "date") date: String): ResponseEntity<Any> {
        return eventService.getEvent(date)
    }

}