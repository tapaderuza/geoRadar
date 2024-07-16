package com.example.GEORADARES.handle;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GeoRadarWebSocketHandler extends TextWebSocketHandler {

    private final Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<>());

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Manejar mensajes entrantes si es necesario
    }

    // Método para enviar actualizaciones en tiempo real
    public void sendUpdate(WebSocketSession session, String update) throws IOException {
        session.sendMessage(new TextMessage(update));
    }

    // Método para obtener todas las sesiones activas
    public Set<WebSocketSession> getSessions() {
        return sessions;
    }
}


