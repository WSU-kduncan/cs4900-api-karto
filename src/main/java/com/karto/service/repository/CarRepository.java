package com.karto.service.repository;

import com.karto.service.model.Car;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {

  List<Car> findByUserEmail(String ownerEmail);
}
