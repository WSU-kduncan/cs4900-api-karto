package com.karto.service.mapper;

import com.karto.service.model.Maintenance;
import com.karto.service.model.MaintenanceReceipt;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MaintenanceReceiptDtoMapper {
  @Mapping(target = "maintenanceId", source = "maintenance.id")
  @Mapping(target = "maintenance", source = "maintenance")
  @Mapping(target = "receipt", source = "receipt")
  MaintenanceReceipt toEntity(Maintenance maintenance, byte[] receipt);
}
