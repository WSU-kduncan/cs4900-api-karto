package com.karto.service.controller;

import com.karto.service.dto.CarDto;
import com.karto.service.mapper.CarDtoMapper;
import com.karto.service.model.Car;
import com.karto.service.service.CarService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(
    path = "cars",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
public class CarController {

  private final CarDtoMapper carDtoMapper;

  private final CarService carService;

  @GetMapping
  ResponseEntity<List<CarDto>> getAllCars() {
    return new ResponseEntity<>(carDtoMapper.toDtoList(carService.getAllCars()), HttpStatus.OK);
  }

  @GetMapping("{carVin}")
  ResponseEntity<CarDto> getCarByVin(@PathVariable String carVin) {
    return new ResponseEntity<>(carDtoMapper.toDto(carService.getCarByVin(carVin)), HttpStatus.OK);
  }

  @GetMapping("ownedBy/{ownerEmail}")
  ResponseEntity<List<CarDto>> getCarsByOwnerEmail(@PathVariable String ownerEmail) {
    return new ResponseEntity<>(
        carDtoMapper.toDtoList(carService.getAllCarsByOwner(ownerEmail)), HttpStatus.OK);
  }

  @PutMapping("{carVin}")
  ResponseEntity<Object> updateCarByVin(
      @PathVariable("carVin") String carVin, @RequestBody CarDto carDto) {
    Car car;

    try {
      car = carService.putCar(carVin, carDto);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }

    return new ResponseEntity<>(carDtoMapper.toDto(car), HttpStatus.OK);
  }
}
