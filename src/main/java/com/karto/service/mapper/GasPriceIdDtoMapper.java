package com.karto.service.mapper;

import com.karto.service.dto.GasPriceDto;
import com.karto.service.dto.GasPriceIdDto;
import com.karto.service.model.GasPrice;
import com.karto.service.model.composite.GasPriceId;
import com.karto.service.service.GasService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GasPriceIdDtoMapper {
  @Mapping(source = "gasStationId", target = "station.id")
  @Mapping(source = "gasTypeId", target = "gasType.id")
  GasPriceId toEntity(GasPriceIdDto gasPriceIdDto) throws EntityNotFoundException;

  @Mapping(target = "gasStationId", source = "station.id")
  @Mapping(target = "gasTypeId", source = "gasType.id")
  GasPriceIdDto toDto(GasPriceId gasPrice) throws EntityNotFoundException;

  List<GasPriceIdDto> toDtoList(List<GasPriceId> gasPriceIdList) throws EntityNotFoundException;

    @Mapping(source = "gasStationId", target = "station.id")
    @Mapping(source = "gasTypeId", target = "gasType.id")
    void updateEntity(GasPriceIdDto gasPriceIdDto, @MappingTarget GasPriceId gasPrice) throws EntityNotFoundException;
}
