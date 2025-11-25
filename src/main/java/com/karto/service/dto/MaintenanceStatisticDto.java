package com.karto.service.dto;

import java.math.BigDecimal;
import java.time.Instant;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MaintenanceStatisticDto {
  BigDecimal totalCost;

  Integer numberMaintenances;

  Integer currentMileage;

  Instant lastUpdated;
}
