package com.karto.service.service;

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
