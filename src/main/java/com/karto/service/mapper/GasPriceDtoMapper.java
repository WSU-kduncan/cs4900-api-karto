package com.karto.service.mapper;

import java.util.List;

import com.karto.service.model.GasPrice;
import com.karto.service.dto.GasPriceDto;

import org.mapstruct.Mapper;
import jakarta.persistence.EntityNotFoundException;

@Mapper(componentModel = "spring")
public interface GasPriceDtoMapper {

    GasPrice toEntity(GasPriceDto gasPriceDto) throws EntityNotFoundException;

    GasPriceDto toDto(GasPrice gasPrice) throws EntityNotFoundException;

    List<GasPriceDto> toDtoList(List<GasPrice> roomList) throws EntityNotFoundException;
}
