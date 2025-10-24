package com.karto.service.mapper;

import com.karto.service.dto.MaintenanceItemDetailIdDto;
import com.karto.service.model.composite.MaintenanceItemDetailId;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MaintenanceItemDetailIdDtoMapper {
  @Mapping(target = "maintenanceId", source = "maintenance.id")
  MaintenanceItemDetailIdDto toDto(MaintenanceItemDetailId id) throws EntityNotFoundException;

  @Mapping(target = "maintenance.id", source = "maintenanceId")
  MaintenanceItemDetailId toEntity(MaintenanceItemDetailIdDto id) throws EntityNotFoundException;

  @Mapping(target = "maintenance.id", source = "maintenanceId")
  void updateEntity(
      MaintenanceItemDetailIdDto detailIdDto, @MappingTarget MaintenanceItemDetailId id);
}
