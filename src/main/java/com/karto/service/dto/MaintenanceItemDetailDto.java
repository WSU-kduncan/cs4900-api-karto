package com.karto.service.dto;

import lombok.Data;

@Data
public class MaintenanceItemDetailDto {
    Integer quantity;

    String comments;

    MaintenanceTypeDescription maintenanceType;
}
