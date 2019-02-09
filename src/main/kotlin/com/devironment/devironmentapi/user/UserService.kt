package com.devironment.devironmentapi.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class UserService @Autowired
constructor(val userRepository: UserRepository) {

    fun login(userId: String, password: String): ResponseEntity<User?> {
        val user = userRepository.findByUserId(userId)

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
        println("Creating user: $userRequest")
        val newUser = userRepository.save(User(
            userId = userRequest.userId,
            password = userRequest.password,
            firstName = userRequest.firstName,
            lastName = userRequest.lastName,
            dateOfBirth = LocalDate.parse(userRequest.dateOfBirth)
        ))
        println("SUCCESS - Created user entity: $newUser")
        userRepository.flush()
        return ResponseEntity.ok().body(newUser)
    }

    fun getUser(userId: String): User? {
        return userRepository.findByUserId(userId)
    }

}