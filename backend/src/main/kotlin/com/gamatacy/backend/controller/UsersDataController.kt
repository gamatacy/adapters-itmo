package com.gamatacy.backend.controller

import com.gamatacy.backend.service.UserDataService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("api/users")
class UsersDataController {
    @Autowired
    private lateinit var userDataService: UserDataService

    @PostMapping("/{username}")
    fun getUser(@PathVariable(value = "username") username: String): ResponseEntity<Any> {
        return userDataService.getUser(username)
    }

    @PostMapping("/page/{page}")
    fun getUsers(@PathVariable(value = "page") page: Int): ResponseEntity<Any> {
        return userDataService.getUsers(page)
    }

}