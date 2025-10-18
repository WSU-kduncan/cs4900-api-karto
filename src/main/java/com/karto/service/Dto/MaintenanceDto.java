package com.karto.service.Dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import lombok.Data;

@Data
public class MaintenanceDto {
    Integer id;

    Instant date;

    Integer mileage;

    BigDecimal cost;

    Byte[] receipt;

    List<MaintenanceItemDetailDto> itemDetails;
}
