package com.karto.service.repository;

import com.karto.service.model.GasPrice;
import com.karto.service.model.GasStation;
import com.karto.service.model.GasType;
import com.karto.service.model.composite.GasPriceId;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GasPriceRepository extends JpaRepository<GasPrice, GasPriceId> {
  Optional<GasPrice> findByIdStationAndIdGasType(GasStation id_station, GasType id_gasType);

  List<GasPrice> findById_GasType_Name(String gasTypeName);
}
