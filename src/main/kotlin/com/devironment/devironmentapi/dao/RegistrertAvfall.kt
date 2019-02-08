package com.devironment.devironmentapi.dao

import java.time.LocalDateTime

data class RegistrertAvfall(
        val kundeid: Int,
        val registreringsDato: LocalDateTime,
        val avfallsKategori: String
)