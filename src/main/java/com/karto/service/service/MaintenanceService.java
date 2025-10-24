package com.karto.service.service;

import com.karto.service.dto.MaintenanceDto;
import com.karto.service.mapper.MaintenanceDtoMapper;
import com.karto.service.model.Maintenance;
import com.karto.service.repository.MaintenanceRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MaintenanceService {
  private final MaintenanceRepository maintenanceRepository;

  private final MaintenanceDtoMapper maintenanceDtoMapper;

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
    return maintenanceRepository.findByCarVinOrderByDateDesc(carVin);
  }

  public Maintenance createMaintenance(MaintenanceDto maintenanceDto) {
    maintenanceDto.setId(null);
    var maintenanceEntity = maintenanceDtoMapper.toEntity(maintenanceDto);
    if (maintenanceDto.getReceipt() != null) {
      var receiptEntity = maintenanceEntity.getReceipt();
      receiptEntity.setMaintenance(maintenanceEntity);
    }
    var maintenanceItemDetailEntities = maintenanceEntity.getItemDetails();
    maintenanceItemDetailEntities.forEach(m -> {
      m.getId().setMaintenance(maintenanceEntity);
    });
    Maintenance savedMaintenance;

    try {
      savedMaintenance = maintenanceRepository.saveAndFlush(maintenanceEntity);
    } catch (DataIntegrityViolationException e) {
      throw new EntityNotFoundException("Duplicate Entry");
    }

    return savedMaintenance;
  }
}
