package com.devironment.devironmentapi.kontrollere

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("verdiskapning")
class SocialScoreController {

    /**
     * Hent Social Score for oppgitt kundeid.
     *
     * @param kundeid
     * @return
     */
    @GetMapping(value = "/score")
    fun hentSocialScore(@RequestParam(value = "kundeid") kundeid: String): List<String> {
        return emptyList()
    }
}