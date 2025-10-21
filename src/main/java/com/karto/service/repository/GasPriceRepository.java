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
//    @Query(
//        value = "SELECT gas_type_id from gas_price gp WHERE gp.gas_type_id = ?1",
//        nativeQuery = true)
    Optional<GasPrice> findByIdStationAndIdGasType(GasStation id_station, GasType id_gasType);

    List<GasPrice> findById_GasType_Name(String gasTypeName);
}
