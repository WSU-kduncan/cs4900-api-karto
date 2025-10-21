package com.karto.service.mapper;

import com.karto.service.dto.GasTypeDto;
import com.karto.service.model.GasType;
import com.karto.service.service.GasService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = {GasService.class})
public interface GasTypeDtoMapper {

  GasType toEntity(GasTypeDto gasTypeDto) throws EntityNotFoundException;

  GasTypeDto toDto(GasType gasType) throws EntityNotFoundException;

  List<GasTypeDto> toDtoList(List<GasType> gasTypeList) throws EntityNotFoundException;
}
