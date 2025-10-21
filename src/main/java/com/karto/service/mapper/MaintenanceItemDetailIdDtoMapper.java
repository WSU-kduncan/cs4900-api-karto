package com.karto.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.karto.service.dto.MaintenanceItemDetailIdDto;
import com.karto.service.model.composite.MaintenanceItemDetailId;
import com.karto.service.service.MaintenanceService;

import jakarta.persistence.EntityNotFoundException;

@Mapper(componentModel = "spring", uses = { MaintenanceService.class })
public interface MaintenanceItemDetailIdDtoMapper {
    @Mapping(target = "maintenanceId", source = "maintenance.id")
    MaintenanceItemDetailIdDto toDto(MaintenanceItemDetailId id) throws EntityNotFoundException;

    @Mapping(target = "maintenance", source = "maintenanceId")
    MaintenanceItemDetailId toEntity(MaintenanceItemDetailIdDto id) throws EntityNotFoundException;
}
