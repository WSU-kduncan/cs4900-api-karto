package com.karto.service.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MaintenanceItemDetailDto {
    Integer quantity;

    String comments;

    MaintenanceItemDetailIdDto id;
}
