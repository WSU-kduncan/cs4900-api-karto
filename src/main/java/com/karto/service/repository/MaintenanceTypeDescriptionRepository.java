package com.karto.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karto.service.model.MaintenanceTypeDescription;

@Repository
public interface MaintenanceTypeDescriptionRepository extends JpaRepository<MaintenanceTypeDescription, Integer> {

}
