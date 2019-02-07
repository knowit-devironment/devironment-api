package com.devironment.devironmentapi.recycling

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/test")
class TestController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun testEndpoint(): List<String>? {
        return null
    }
}