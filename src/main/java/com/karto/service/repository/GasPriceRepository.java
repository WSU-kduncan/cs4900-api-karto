package com.karto.service.repository;

import com.karto.service.model.GasPrice;
import com.karto.service.model.composite.GasPriceId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GasPriceRepository extends JpaRepository<GasPrice, GasPriceId> {

  List<GasPrice> findById_GasType_Name(String gasTypeName);
}
