package com.example.GEORADARES.repository;

import com.example.GEORADARES.model.GeoRadar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface geoRadarRepository extends JpaRepository<GeoRadar, Long> {


}
