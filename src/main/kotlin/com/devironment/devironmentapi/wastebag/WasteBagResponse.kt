package com.devironment.devironmentapi.wastebag

data class WasteBagResponse(
    val bagId: String,
    val wasteCategory: WasteCategory,
    val dateOfDisposal: String,
    val userId: String,
    val delivered: Boolean
)