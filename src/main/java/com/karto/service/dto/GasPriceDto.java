package com.karto.service.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Data
@Value
public class GasPriceDto {

    GasPriceIdDto id;

    BigDecimal price;

    Instant updated;
}
