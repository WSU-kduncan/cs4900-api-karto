package com.karto.service.repository;

import com.karto.service.model.Maintenance;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {
  List<Maintenance> findByCarVinOrderByDateDesc(String vin);
}
