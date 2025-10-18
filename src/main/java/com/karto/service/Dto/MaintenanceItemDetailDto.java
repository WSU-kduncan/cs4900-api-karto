package com.karto.service.Dto;

import lombok.Data;

@Data
public class MaintenanceItemDetailDto {
    Integer quantity;

    String comments;

    MaintenanceTypeDescription maintenanceType;
}
