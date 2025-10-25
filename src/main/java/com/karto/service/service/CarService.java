package com.karto.service.service;

import com.karto.service.dto.CarDto;
import com.karto.service.mapper.CarDtoMapper;
import com.karto.service.model.Car;
import com.karto.service.model.CarImage;
import com.karto.service.repository.CarImageRepository;
import com.karto.service.repository.CarRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CarService {

  private final CarRepository carRepository;

  private final CarImageRepository carImageRepository;

  private final CarDtoMapper carDtoMapper;

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

    return carRepository.saveAndFlush(carDtoMapper.updateEntity(carDto, existingCar));
  }

  public Car createNewCar(CarDto carDto) throws EntityNotFoundException {
    return carRepository.saveAndFlush(carDtoMapper.toEntity(carDto));
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
