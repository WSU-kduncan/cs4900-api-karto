package com.karto.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karto.service.model.Maintenance;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {
    List<Maintenance> findByCarVin(String vin);
}
