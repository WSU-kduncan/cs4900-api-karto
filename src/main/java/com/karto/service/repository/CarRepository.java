package com.karto.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karto.service.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {

  List<Car> findByUserEmail(String ownerEmail);
}
