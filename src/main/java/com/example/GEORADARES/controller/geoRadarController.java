package com.example.GEORADARES.controller;

import com.example.GEORADARES.model.geoRadar;
import com.example.GEORADARES.service.geoRadarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/georadars")
public class geoRadarController {

    @Autowired
    private geoRadarService geoRadarService;

    @GetMapping
    public List<geoRadar> getAllGeoRadars(){
        return geoRadarService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<geoRadar> getRadarById(@PathVariable Long id){
        return geoRadarService.findById(id);
    }

    @PostMapping
    public geoRadar createGeoRadar (@RequestBody geoRadar geoRadar){
        return geoRadarService.save(geoRadar);
    }

    @PutMapping("/{id}")
    public geoRadar updateGeoRadar (@PathVariable Long id, @RequestBody geoRadar geoRadar){
        geoRadar.setId(id);
        return geoRadarService.save(geoRadar);
    }

    @DeleteMapping("/{id}")
    public void deleteGeoRadar(@PathVariable Long id){
        geoRadarService.deleteById(id);
    }

}
