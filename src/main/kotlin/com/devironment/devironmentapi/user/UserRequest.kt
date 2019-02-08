package com.devironment.devironmentapi.user

data class UserRequest(
    val userId: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val dateOfBirth: String
)