package com.karto.service.mapper;

import com.karto.service.dto.MaintenanceTypeDescriptionDto;
import com.karto.service.model.MaintenanceTypeDescription;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaintenanceTypeDescriptionDtoMapper {
  MaintenanceTypeDescription toEntity(MaintenanceTypeDescriptionDto dto)
      throws EntityNotFoundException;

  MaintenanceTypeDescriptionDto tDto(MaintenanceTypeDescription entity)
      throws EntityNotFoundException;
}
