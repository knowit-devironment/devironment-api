package com.devironment.devironmentapi.backoffice

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.stereotype.Service
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler


class Message(val msgType: String, val data: Any)

@Service
class WasteNotificationService : TextWebSocketHandler() {

    val sessionList = ArrayList<WebSocketSession>()

    @Throws(Exception::class)
    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        sessionList.add(session)
    }

    override fun afterConnectionEstablished(session: WebSocketSession) {
        sessionList.remove(session)
    }

    fun connections(): ArrayList<WebSocketSession> {
        return sessionList
    }

    fun emit(session: WebSocketSession, msg: Message) = session.sendMessage(TextMessage(jacksonObjectMapper().writeValueAsString(msg)))
    fun broadcast(msg: Message) = sessionList.forEach { emit(it, msg) }
}