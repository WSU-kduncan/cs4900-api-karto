package com.karto.service.mapper;

import com.karto.service.dto.GasPriceDto;
import com.karto.service.model.GasPrice;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = {GasPriceIdDtoMapper.class})
public interface GasPriceDtoMapper {

  GasPrice toEntity(GasPriceDto gasPriceDto) throws EntityNotFoundException;

  GasPriceDto toDto(GasPrice gasPrice) throws EntityNotFoundException;

  List<GasPriceDto> toDtoList(List<GasPrice> gasPriceList) throws EntityNotFoundException;
}
