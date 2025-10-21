package com.karto.service.repository;

import com.karto.service.model.GasPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GasPriceRepository extends JpaRepository<GasPrice, Integer> {
    List<GasPrice> findByGasStationNameOrderByValue(String stationName);
}
