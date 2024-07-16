package com.example.GEORADARES.service;

import com.example.GEORADARES.model.geoRadar;
import com.example.GEORADARES.repository.geoRadarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class geoRadarService {

    @Autowired
    private geoRadarRepository geoRadarRepository;



    public List<geoRadar> findAll(){
        return geoRadarRepository.findAll();
    }

    public Optional<geoRadar> findById(Long id){
        return geoRadarRepository.findById(id);
    }

    public geoRadar save (geoRadar geoRadar){
        return geoRadarRepository.save(geoRadar);
    }

    public void deleteById (Long id){
        geoRadarRepository.deleteById(id);
    }



}
