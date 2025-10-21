package com.karto.service.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class GasPriceIdDto {

    Integer stationId;

    Integer gasTypeId;
}
