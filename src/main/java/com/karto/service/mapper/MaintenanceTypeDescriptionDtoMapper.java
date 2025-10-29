package com.karto.service.mapper;

import com.karto.service.dto.MaintenanceTypeDescriptionDto;
import com.karto.service.model.MaintenanceTypeDescription;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaintenanceTypeDescriptionDtoMapper {
  MaintenanceTypeDescription toEntity(MaintenanceTypeDescriptionDto dto)
      throws EntityNotFoundException;

  MaintenanceTypeDescriptionDto toDto(MaintenanceTypeDescription entity)
      throws EntityNotFoundException;

  List<MaintenanceTypeDescriptionDto> toDtoList(List<MaintenanceTypeDescription> entityList);
}
