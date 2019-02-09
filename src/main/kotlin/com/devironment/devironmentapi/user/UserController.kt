package com.devironment.devironmentapi.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/users")
class UserController @Autowired
constructor(val userService: UserService) {

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<User?> {
        return userService.login(
            userId = loginRequest.userId,
            password = loginRequest.userId
        )
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    fun createUser(@RequestBody userRequest: UserRequest) : ResponseEntity<User?> {
        return userService.createUser(userRequest)
    }
}