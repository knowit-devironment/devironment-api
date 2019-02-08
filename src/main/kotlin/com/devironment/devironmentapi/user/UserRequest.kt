package com.devironment.devironmentapi.user

import java.time.LocalDate

data class UserRequest(
    val userName: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val dateOfBirth: LocalDate
)