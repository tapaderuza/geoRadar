package com.example.GEORADARES.service;

import com.example.GEORADARES.model.GeoRadar;
import com.example.GEORADARES.repository.geoRadarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class geoRadarService {

    @Autowired
    private geoRadarRepository geoRadarRepository;



    public List<GeoRadar> findAll(){
        return geoRadarRepository.findAll();
    }

    public Optional<GeoRadar> findById(Long id){
        return geoRadarRepository.findById(id);
    }

    public GeoRadar save (GeoRadar geoRadar){
        return geoRadarRepository.save(geoRadar);
    }

    public void deleteById (Long id){
        geoRadarRepository.deleteById(id);
    }



}
