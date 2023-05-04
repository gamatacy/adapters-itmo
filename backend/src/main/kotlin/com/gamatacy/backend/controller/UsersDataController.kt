package com.gamatacy.backend.controller

import com.gamatacy.backend.service.UserDataService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController()
@RequestMapping("api/users")
class UsersDataController {
    @Autowired
    private lateinit var userDataService: UserDataService

    @GetMapping("/{username}")
    fun getUser(@PathVariable(value = "username") username: String): ResponseEntity<Any> {
        return userDataService.getUser(username)
    }

    @GetMapping("/page/{page}")
    fun getUsers(@PathVariable(value = "page") page: Int): ResponseEntity<Any> {
        return userDataService.getUsers(page)
    }

}