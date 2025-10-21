package com.karto.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karto.service.model.GasStation;

@Repository
public interface GasStationRepository extends JpaRepository<GasStation, Integer> {
    List<GasStation> findByNameContainingIgnoreCase(String name);
}