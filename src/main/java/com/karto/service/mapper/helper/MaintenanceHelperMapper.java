package com.karto.service.mapper.helper;

import com.karto.service.model.Maintenance;
import com.karto.service.repository.MaintenanceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MaintenanceHelperMapper {
  private final MaintenanceRepository maintenanceRepository;

  public Maintenance getMaintenanceById(Integer id) throws EntityNotFoundException {
    return maintenanceRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Maintenance: ID " + id + " Not Found"));
  }
}
