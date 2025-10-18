package com.karto.service.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MaintenanceTypeDescription {
    Integer id;
    String name;
}
