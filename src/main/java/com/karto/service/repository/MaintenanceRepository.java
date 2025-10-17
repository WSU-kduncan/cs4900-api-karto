package com.karto.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karto.service.model.Maintenance;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {

}
