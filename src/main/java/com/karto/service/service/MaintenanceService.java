package com.karto.service.service;

import com.karto.service.dto.MaintenanceDto;
import com.karto.service.mapper.MaintenanceDtoMapper;
import com.karto.service.mapper.MaintenanceItemDetailDtoMapper;
import com.karto.service.mapper.MaintenanceReceiptDtoMapper;
import com.karto.service.model.Maintenance;
import com.karto.service.repository.MaintenanceItemDetailRepostiry;
import com.karto.service.repository.MaintenanceReceiptRepository;
import com.karto.service.repository.MaintenanceRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MaintenanceService {
  private final MaintenanceRepository maintenanceRepository;

  private final MaintenanceItemDetailRepostiry maintenanceItemDetailRepostiry;

  private final MaintenanceItemDetailDtoMapper maintenanceItemDetailDtoMapper;

  private final MaintenanceReceiptDtoMapper maintenanceReceiptDtoMapper;

  private final MaintenanceReceiptRepository maintenanceReceiptRepository;

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
    var maintenanceItemDetails = maintenanceDto.getItemDetails();
    maintenanceDto.setItemDetails(null);

    var maintenanceReceipt = maintenanceDto.getReceipt();
    maintenanceDto.setReceipt(null);

    var maintenanceEntity = maintenanceDtoMapper.toEntity(maintenanceDto);
    maintenanceEntity.setReceipt(null);

    var savedMaintenance = maintenanceRepository.save(maintenanceEntity);
    var maintenanceReceiptEntity =
        maintenanceReceiptDtoMapper.toEntity(savedMaintenance, maintenanceReceipt);
    maintenanceReceiptRepository.save(maintenanceReceiptEntity);

    maintenanceItemDetails.forEach(m -> m.getId().setMaintenanceId(savedMaintenance.getId()));
    var maintenanceItemDetailEntities =
        maintenanceItemDetailDtoMapper.toEntityList(maintenanceItemDetails);
    maintenanceItemDetailRepostiry.saveAll(maintenanceItemDetailEntities);

    maintenanceItemDetailRepostiry.flush();
    maintenanceReceiptRepository.flush();
    maintenanceRepository.flush();
    return savedMaintenance;
  }
}
