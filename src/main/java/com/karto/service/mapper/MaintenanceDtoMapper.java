package com.karto.service.mapper;

import com.karto.service.dto.MaintenanceDto;
import com.karto.service.model.Maintenance;
import com.karto.service.service.CarService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { MaintenanceItemDetailDtoMapper.class, CarService.class
})
public interface MaintenanceDtoMapper {
  @Mapping(source = "carVin", target = "car")
  @Mapping(source = "id", target = "receipt.maintenanceId")
  Maintenance toEntity(MaintenanceDto maintenanceDto) throws EntityNotFoundException;

  @Mapping(source = "car.vin", target = "carVin")
  @Mapping(source = "receipt.receipt", target = "receipt")
  MaintenanceDto toDto(Maintenance maintenance) throws EntityNotFoundException;

  List<MaintenanceDto> toDtoList(List<Maintenance> maintenances);
}
