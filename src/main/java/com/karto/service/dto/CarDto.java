package com.karto.service.dto;

import java.time.Year;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class CarDto {

  String vin;

  Byte[] image;

  String userEmail;

  String make;

  String model;

  Year year;

  String color;

  Integer mileage;

  GasTypeDto gasType;
}
