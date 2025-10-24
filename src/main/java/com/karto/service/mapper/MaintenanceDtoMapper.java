package com.karto.service.mapper;

import com.karto.service.dto.MaintenanceDto;
import com.karto.service.model.Maintenance;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(
    componentModel = "spring",
    uses = {MaintenanceItemDetailDtoMapper.class})
public interface MaintenanceDtoMapper {
  @Mapping(source = "carVin", target = "car.vin")
  @Mapping(source = "receipt", target = "receipt.receipt")
  Maintenance toEntity(MaintenanceDto maintenanceDto) throws EntityNotFoundException;

  @Mapping(source = "car.vin", target = "carVin")
  @Mapping(source = "receipt.receipt", target = "receipt")
  MaintenanceDto toDto(Maintenance maintenance) throws EntityNotFoundException;

  @Mapping(source = "receipt", target = "receipt.receipt")
  @Mapping(source = "carVin", target = "car.vin")
  @Mapping(target = "id", ignore = true)
  void updateEntity(MaintenanceDto maintenanceDto, @MappingTarget Maintenance maintenance);

  List<MaintenanceDto> toDtoList(List<Maintenance> maintenances);
}
