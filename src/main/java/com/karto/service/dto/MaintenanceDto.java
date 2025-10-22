package com.karto.service.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MaintenanceDto {
  Integer id;

  String carVin;

  Instant date;

  Integer mileage;

  BigDecimal cost;

  Byte[] receipt;

  List<MaintenanceItemDetailDto> itemDetails;
}
