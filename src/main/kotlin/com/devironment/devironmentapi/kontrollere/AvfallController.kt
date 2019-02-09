package com.devironment.devironmentapi.kontrollere

import com.devironment.devironmentapi.dao.RegistrertAvfall
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("avfall")
class AvfallController {

    /**
     * Brukes av klient for å registrere avfallsKategori.
     *
     * @param kundeid
     * @param avfallskategori
     * @param qrkode
     * @return
     */
    @PutMapping(value = "/registrer")
    fun registrerAvfall(
            @RequestParam(value = "kundeid") kundeid: String,
            @RequestParam(value = "avfallskategori") avfallskategori: String,
            @RequestParam(value = "qrkode") qrkode: String
    ): HttpStatus {

        // TODO: Burde logge tid/dato dette registreres.

        return HttpStatus.OK
    }

    /**
     * Hent registrert avfallsKategori for oppgitt kundeid.
     * @param kundeid
     * @return
     */
    @GetMapping(value = "/registrert")
    fun hentRegistrertAvfall(@RequestParam(value = "kundeid") kundeid: String): List<RegistrertAvfall> {
        return emptyList()
    }
}