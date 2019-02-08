package com.devironment.devironmentapi.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService @Autowired
constructor(val userRepository: UserRepository) {

    fun login(userName: String, password: String): ResponseEntity<User?> {
        val user = userRepository.findByUserName(userName)

        user?.let {
            return if (password == it.password) {
                ResponseEntity.ok().body(user)
            } else {
                ResponseEntity(HttpStatus.UNAUTHORIZED)
            }
        }
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }

    fun createUser(userRequest: UserRequest): ResponseEntity<User?> {
        // TODO: Add check for if user name exists
        val newUser = userRepository.save(User(
            userName = userRequest.userName,
            password = userRequest.password,
            firstName = userRequest.firstName,
            lastName = userRequest.lastName,
            dateOfBirth = userRequest.dateOfBirth
        ))
        userRepository.flush()
        return ResponseEntity.ok().body(newUser)
    }

}