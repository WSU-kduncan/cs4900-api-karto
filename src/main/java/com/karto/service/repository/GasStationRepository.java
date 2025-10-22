package com.karto.service.repository;

import com.karto.service.model.GasStation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GasStationRepository extends JpaRepository<GasStation, Integer> {
}
