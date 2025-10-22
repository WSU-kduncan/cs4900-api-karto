package com.karto.service.dto;

import java.math.BigDecimal;
import java.time.Instant;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class GasPriceDto {

  GasPriceIdDto id;

  BigDecimal price;

  Instant updated;
}
