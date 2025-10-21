package com.karto.service.repository;

import com.karto.service.model.GasPrice;
import com.karto.service.model.GasStation;
import com.karto.service.model.composite.GasPriceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GasStationRepository extends JpaRepository<GasStation, Integer> {
}
