package com.karto.service.mapper;

import org.mapstruct.Mapper;

import com.karto.service.dto.MaintenanceTypeDescriptionDto;
import com.karto.service.model.MaintenanceTypeDescription;

import jakarta.persistence.EntityNotFoundException;

@Mapper(componentModel = "spring")
public interface MaintenanceTypeDescriptionDtoMapper {
    MaintenanceTypeDescription toEntity(MaintenanceTypeDescriptionDto dto) throws EntityNotFoundException;

    MaintenanceTypeDescriptionDto tDto(MaintenanceTypeDescription entity) throws EntityNotFoundException;
}
