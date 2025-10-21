package com.karto.service.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GasStationDto {
    Integer id;
    BigDecimal longitude;
    BigDecimal latitude;
    String name;
    String addressLine;
    String city;
    String state;
    String zip;
}
