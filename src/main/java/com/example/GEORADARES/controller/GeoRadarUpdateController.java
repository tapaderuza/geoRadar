package com.example.GEORADARES.controller;

import com.example.GEORADARES.service.GeoRadarUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/updates")
public class GeoRadarUpdateController {

    @Autowired
    private GeoRadarUpdateService updateService;

    @PostMapping("/send")
    public void sendUpdate(String update) throws IOException {
        updateService.sendUpdateToAll(update);
    }
}
