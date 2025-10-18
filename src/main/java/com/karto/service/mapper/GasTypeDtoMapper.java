package com.karto.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.karto.service.dto.GasTypeDto;
import com.karto.service.model.GasType;

import jakarta.persistence.EntityNotFoundException;

@Mapper(componentModel = "spring")
public interface GasTypeDtoMapper {

    GasType toEntity(GasTypeDto buildingDto) throws EntityNotFoundException;

    GasTypeDto toDto(GasType building) throws EntityNotFoundException;

    List<GasTypeDto> toDtoList(List<GasType> gasTypeList) throws EntityNotFoundException;

}
