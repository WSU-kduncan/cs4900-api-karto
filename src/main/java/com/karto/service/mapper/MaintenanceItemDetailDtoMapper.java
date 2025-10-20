package com.karto.service.mapper;

import org.mapstruct.Mapper;

import com.karto.service.dto.MaintenanceItemDetailDto;
import com.karto.service.model.MaintenanceItemDetail;

import jakarta.persistence.EntityNotFoundException;

@Mapper(componentModel = "spring", uses = { MaintenanceItemDetailIdDtoMapper.class })
public interface MaintenanceItemDetailDtoMapper {
    MaintenanceItemDetail toEntity(MaintenanceItemDetailDto maintenanceItemDetailDto) throws EntityNotFoundException;

    MaintenanceItemDetailDto toDto(MaintenanceItemDetail maintenanceItemDetail) throws EntityNotFoundException;
}
