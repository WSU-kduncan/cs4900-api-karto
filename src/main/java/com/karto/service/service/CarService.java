package com.karto.service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.karto.service.dto.CarDto;
import com.karto.service.mapper.CarDtoMapper;
import com.karto.service.model.Car;
import com.karto.service.model.CarImage;
import com.karto.service.repository.CarImageRepository;
import com.karto.service.repository.CarRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CarService {

  private final CarRepository carRepository;

  private final CarImageRepository carImageRepository;

  private final CarDtoMapper carDtoMapper;
  
  private final GasService gasService;

  public List<Car> getAllCars() throws EntityNotFoundException {
    return carRepository.findAll();
  }

  public List<Car> getAllCarsByOwner(String ownerEmail) throws EntityNotFoundException {
    return carRepository.findByUserEmail(ownerEmail);
  }

  public Car getCarByVin(String id) throws EntityNotFoundException {
    Optional<Car> response = carRepository.findById(id);

    if (response.isEmpty()) {
      throw new EntityNotFoundException("Car with id " + id + " not found.");
    }

    return response.get();
  }

  public Car putCar(String vin, CarDto carDto) throws EntityNotFoundException {
    Car existingCar = carRepository
        .findById(vin)
        .orElseThrow(() -> new EntityNotFoundException("Car with vin " + vin + " not found."));

    // Let the mapper update the mutable fields on the existing entity
    Car updatedCar = carDtoMapper.updateEntity(carDto, existingCar);

    // If the request provided a gasTypeId, load the managed GasType entity and set it
    if (carDto.getGasTypeId() != null) {
      updatedCar.setGasType(gasService.getGasTypeById(carDto.getGasTypeId()));
    }

    return carRepository.saveAndFlush(updatedCar);
  }

  public Car createNewCar(CarDto carDto) throws EntityNotFoundException {
    // Ensure the car does not already exist
    if (carRepository.existsById(carDto.getVin())) {
      throw new DataIntegrityViolationException(
          "Car with vin " + carDto.getVin() + " already exists.");
    }

    Car car = carDtoMapper.toEntity(carDto);

    // If caller provided a gasTypeId, fetch the managed GasType entity and attach it
    if (carDto.getGasTypeId() != null) {
      car.setGasType(gasService.getGasTypeById(carDto.getGasTypeId()));
    }

    return carRepository.saveAndFlush(car);
  }

  /**
   * Car Image Service
   */
  public List<CarImage> getAllCarImages() throws EntityNotFoundException {
    return carImageRepository.findAll();
  }

  public CarImage getCarImageByVin(String vin) throws EntityNotFoundException {
    Optional<CarImage> response = carImageRepository.findByCarVin(vin);

    if (response.isEmpty()) {
      throw new EntityNotFoundException("Car image with vin " + vin + " not found.");
    }

    return response.get();
  }
}
