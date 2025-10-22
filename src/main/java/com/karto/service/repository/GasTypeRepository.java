package com.karto.service.repository;

import com.karto.service.model.GasType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GasTypeRepository extends JpaRepository<GasType, Integer> {
  Optional<GasType> findByName(String name);
}
