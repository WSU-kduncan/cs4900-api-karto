package com.karto.service.repository;

import com.karto.service.model.GasPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GasPriceRepository extends JpaRepository<GasPrice, Integer> {

    @Query(
        value = "SELECT * from gas_price gp JOIN gas_type gt ON gp.gas_type_id = gt.gas_type_id WHERE gt.name = ?1",
        nativeQuery = true
    )
    List<GasPrice> findGasPricesByGasType(String gasType);
}
