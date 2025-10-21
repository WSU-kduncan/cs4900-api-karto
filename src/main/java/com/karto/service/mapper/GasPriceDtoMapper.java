package com.karto.service.mapper;

import java.util.List;

import com.karto.service.model.GasPrice;
import com.karto.service.dto.GasPriceDto;

import com.karto.service.service.GasService;
import org.mapstruct.Mapper;
import jakarta.persistence.EntityNotFoundException;

@Mapper(componentModel = "spring", uses = { GasService.class })
public interface GasPriceDtoMapper {

    GasPrice toEntity(GasPriceDto gasPriceDto) throws EntityNotFoundException;

    GasPriceDto toDto(GasPrice gasPrice) throws EntityNotFoundException;

    List<GasPriceDto> toDtoList(List<GasPrice> gasPriceList) throws EntityNotFoundException;
}
