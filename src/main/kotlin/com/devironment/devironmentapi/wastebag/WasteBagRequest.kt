package com.devironment.devironmentapi.wastebag

import com.devironment.devironmentapi.user.User

data class WasteBagRequest(
    val bagId: String,
    val wasteCategory: WasteCategory,
    val dateOfDisposal: String,
    val delivered: Boolean = false,
    val userId: String
)