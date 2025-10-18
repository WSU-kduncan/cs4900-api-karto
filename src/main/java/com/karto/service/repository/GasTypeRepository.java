package com.karto.service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.karto.service.model.GasType;

@Repository
public interface GasTypeRepository extends JpaRepository<GasType, Integer> {

    @Query(value = "SELECT gt.gas_type_id FROM gas_type gt WHERE gt.name = ?1", nativeQuery = true)
    Optional<GasType> findByName(String name);
}
