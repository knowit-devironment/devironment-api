package com.devironment.devironmentapi.backoffice

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("backoffice")
class HtmlController @Autowired constructor(val notificationService: WasteNotificationService) {



    @GetMapping("connections")
    fun connections() : String {
        return notificationService.connections().size.toString()
    }

    // Checkout: https://medium.com/@codemwnci/kotlin-springboot-and-websockets-276029b22482
    @GetMapping()
    fun getRawHtmlOOOops(): String {
        return ""
    }
}