package com.karto.service.dto;

import java.math.BigDecimal;
import java.util.Set;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class GasStationDto {

  Integer id;

  BigDecimal longitude;

  BigDecimal latitude;

  String name;

  String addressLine;

  String city;

  String state;

  String zip;

  Set<UserDto> users;
}
