package com.karto.service.mapper;

import java.util.List;

import com.karto.service.dto.GasPriceIdDto;
import com.karto.service.model.GasPrice;
import com.karto.service.dto.GasPriceDto;

import com.karto.service.model.composite.GasPriceId;
import com.karto.service.service.GasService;
import org.mapstruct.Mapper;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = GasService.class)
public interface GasPriceIdDtoMapper {
    @Mapping(source = "gasStationId", target = "station")
    @Mapping(source = "gasTypeId", target = "gasType")
    GasPriceId toEntity(GasPriceIdDto gasPriceIdDto) throws EntityNotFoundException;

    @Mapping(target = "gasStationId", source = "station.id")
    @Mapping(target = "gasTypeId", source = "gasType.id")
    GasPriceIdDto toDto(GasPriceId gasPrice) throws EntityNotFoundException;

    List<GasPriceIdDto> toDtoList(List<GasPriceId> gasPriceIdList) throws EntityNotFoundException;

}
