package com.devironment.devironmentapi.user

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String> {

    fun findByUserName(userName: String): User?
}