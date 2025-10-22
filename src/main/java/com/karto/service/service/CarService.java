package com.karto.service.service;

import com.karto.service.model.Car;
import com.karto.service.repository.CarRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarService {
  private final CarRepository carRepository;

  public Car getCarById(String id) throws EntityNotFoundException {
    var response = carRepository.findById(id);
    if (response.isEmpty()) throw new EntityNotFoundException("Car: ID " + id + " Not Found");
    return response.get();
  }
}
