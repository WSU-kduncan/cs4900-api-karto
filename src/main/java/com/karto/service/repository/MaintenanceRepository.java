package com.karto.service.repository;

import com.karto.service.model.Maintenance;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {
  List<Maintenance> findByCarVinOrderByDateDesc(String vin);

  Maintenance findFirstByCarVinOrderByDateDesc(String vin);

  Integer countByCarVin(String vin);

  @Query("SELECT SUM(m.cost) FROM Maintenance m WHERE m.car.vin = :vin")
  BigDecimal sumCostByCarVin(String vin);
}
