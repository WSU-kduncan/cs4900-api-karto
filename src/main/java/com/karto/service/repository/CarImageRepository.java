package com.karto.service.repository;

import com.karto.service.model.CarImage;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarImageRepository extends JpaRepository<CarImage, String> {

  Optional<CarImage> findByCarVin(String carVin);
}
