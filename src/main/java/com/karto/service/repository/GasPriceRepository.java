package com.karto.service.repository;

import com.karto.service.model.GasPrice;
import com.karto.service.model.GasStation;
import com.karto.service.model.GasType;
import com.karto.service.model.composite.GasPriceId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GasPriceRepository extends JpaRepository<GasPrice, GasPriceId> {
    Optional<GasPrice> findByIdStationAndIdGasType(GasStation stationId, GasType gasType);

    List<GasPrice> findById_GasType_Name(String gasTypeName);
}
