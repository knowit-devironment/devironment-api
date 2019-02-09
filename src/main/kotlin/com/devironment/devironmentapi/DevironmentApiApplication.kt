package com.devironment.devironmentapi

import com.devironment.devironmentapi.backoffice.WasteNotificationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

@SpringBootApplication
class DevironmentApiApplication

@Configuration
@EnableWebSocket
class WSConfig @Autowired constructor(val wasteNotificationService: WasteNotificationService) : WebSocketConfigurer {

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(wasteNotificationService, "/ws").withSockJS()
    }
}

fun main(args: Array<String>) {
    runApplication<DevironmentApiApplication>(*args)
}

