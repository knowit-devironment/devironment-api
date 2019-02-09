package com.devironment.devironmentapi.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserRepository : JpaRepository<User, String> {

    @Query("select u from User u where userId = :userId")
    fun findByUserId(userId: String): User?
}