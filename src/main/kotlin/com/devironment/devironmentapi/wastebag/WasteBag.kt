package com.devironment.devironmentapi.wastebag

import com.devironment.devironmentapi.user.User
import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
data class WasteBag(
    @Id val bagId: String,
    val wasteCategory: WasteCategory,
    val dateOfDisposal: LocalDate,
    @JsonIgnore @ManyToOne @JoinColumn(name = "user_id") val user: User
)