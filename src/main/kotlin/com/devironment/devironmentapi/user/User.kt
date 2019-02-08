package com.devironment.devironmentapi.user

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class User (
    @Id val userName: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val dateOfBirth: LocalDate
)