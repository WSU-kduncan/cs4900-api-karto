package com.karto.service.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MaintenanceTypeDescriptionDto {
  Integer id;
  String name;
}
