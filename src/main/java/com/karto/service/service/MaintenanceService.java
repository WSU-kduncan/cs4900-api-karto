package com.karto.service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.karto.service.model.Maintenance;
import com.karto.service.model.MaintenanceReceipt;
import com.karto.service.repository.MaintenanceReceiptRepository;
import com.karto.service.repository.MaintenanceRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MaintenanceService {
    private final MaintenanceRepository maintenanceRepository;

    private final MaintenanceReceiptRepository receiptRepository;

    public Maintenance getMaintenanceById(Integer id) throws EntityNotFoundException {
        var response = maintenanceRepository.findById(id);
        if (response.isEmpty())
            throw new EntityNotFoundException("Maintenance: ID " + id + " Not Found");
        return response.get();
    }

    public List<Maintenance> getAllMaintenance() {
        return maintenanceRepository.findAll();
    }

    public List<Maintenance> getAllMaintenanceByCar(String carVin) {
        return maintenanceRepository.findByCarVin(carVin);
    }

    public MaintenanceReceipt getMaintenanceReceiptById(Integer id) {
        var response = receiptRepository.findById(id);
        return response.orElse(null);
    }
}
