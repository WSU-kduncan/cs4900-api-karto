package com.karto.service.mapper;

import com.karto.service.dto.MaintenanceItemDetailIdDto;
import com.karto.service.mapper.helper.MaintenanceHelperMapper;
import com.karto.service.model.composite.MaintenanceItemDetailId;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    componentModel = "spring",
    uses = {MaintenanceHelperMapper.class})
public interface MaintenanceItemDetailIdDtoMapper {
  @Mapping(target = "maintenanceId", source = "maintenance.id")
  MaintenanceItemDetailIdDto toDto(MaintenanceItemDetailId id) throws EntityNotFoundException;

  @Mapping(target = "maintenance", source = "maintenanceId", conditionExpression = "java(id.getMaintenanceId() != null)")
  MaintenanceItemDetailId toEntity(MaintenanceItemDetailIdDto id) throws EntityNotFoundException;
}
