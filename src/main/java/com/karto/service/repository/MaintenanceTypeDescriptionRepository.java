package com.karto.service.repository;

import com.karto.service.model.MaintenanceTypeDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceTypeDescriptionRepository
    extends JpaRepository<MaintenanceTypeDescription, Integer> {}
