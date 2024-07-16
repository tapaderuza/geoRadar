package com.example.GEORADARES.repository;

import com.example.GEORADARES.model.geoRadar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface geoRadarRepository extends JpaRepository<geoRadar, Long> {


}
