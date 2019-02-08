package com.devironment.devironmentapi.user

import java.io.Serializable
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class User (
    @Id val userId: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val dateOfBirth: LocalDate
): Serializable