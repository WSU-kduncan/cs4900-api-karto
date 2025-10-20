package com.karto.service.service;

import org.springframework.stereotype.Service;

import com.karto.service.model.Maintenance;
import com.karto.service.repository.MaintenanceRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MaintenanceService {
    MaintenanceRepository maintenanceRepository;

    public Maintenance getMaintenanceById(Integer id) throws EntityNotFoundException {
        var response = maintenanceRepository.findById(id);
        if (response.isEmpty())
            throw new EntityNotFoundException("Maintenance: ID " + id + " Not Found");
        return response.get();
    }
}
