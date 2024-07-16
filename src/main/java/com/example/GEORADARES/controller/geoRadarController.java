package com.example.GEORADARES.controller;

import com.example.GEORADARES.model.GeoRadar;
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
    public List<GeoRadar> getAllGeoRadars(){
        return geoRadarService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<GeoRadar> getRadarById(@PathVariable Long id){
        return geoRadarService.findById(id);
    }

    @PostMapping
    public GeoRadar createGeoRadar (@RequestBody GeoRadar geoRadar){
        return geoRadarService.save(geoRadar);
    }

    @PutMapping("/{id}")
    public GeoRadar updateGeoRadar (@PathVariable Long id, @RequestBody GeoRadar geoRadar){
        geoRadar.setId(id);
        return geoRadarService.save(geoRadar);
    }

    @DeleteMapping("/{id}")
    public void deleteGeoRadar(@PathVariable Long id){
        geoRadarService.deleteById(id);
    }

}
