package com.devironment.devironmentapi.kontrollere

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class BildeleserController {

    /**
     * Endepunkt for registrering av QR-kode fra bildeleseren.
     *
     * @param qrcode
     * @return
     */
    @PutMapping(value = "/qrregistrert")
    fun registrerQr(@RequestParam(value = "qrcode") qrcode: Optional<String>): HttpStatus {
        if (qrcode.isPresent) {
            return HttpStatus.OK
        }
        return HttpStatus.NO_CONTENT
    }
}