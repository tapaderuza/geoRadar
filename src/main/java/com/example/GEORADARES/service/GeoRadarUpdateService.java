package com.example.GEORADARES.service;

import com.example.GEORADARES.handle.GeoRadarWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@Service
public class GeoRadarUpdateService {

    @Autowired
    private GeoRadarWebSocketHandler webSocketHandler;

    // Método para enviar actualizaciones a todos los clientes conectados
    public void sendUpdateToAll(String update) {
        for (WebSocketSession session : webSocketHandler.getSessions()) {
            try {
                webSocketHandler.sendUpdate(session, update);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

