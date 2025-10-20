package com.karto.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MaintenanceItemDetailIdDto {
    Integer maintenanceId;

    MaintenanceTypeDescriptionDto maintenanceType;
}
