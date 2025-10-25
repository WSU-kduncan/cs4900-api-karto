package com.karto.service.dto;

import java.time.Year;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CarDto {

  String vin;

  Byte[] image;

  String userEmail;

  String make;

  String model;

  Year year;

  String color;

  Integer mileage;

  Integer gasTypeId;
}
