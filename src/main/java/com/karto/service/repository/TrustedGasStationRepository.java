package com.karto.service.repository;

import com.karto.service.model.GasStation;
import com.karto.service.model.TrustedGasStation;
import com.karto.service.model.User;
import com.karto.service.model.composite.TrustedGasStationId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TrustedGasStationRepository
    extends JpaRepository<TrustedGasStation, TrustedGasStationId> {
  TrustedGasStation findByUserAndGasStation(User user, GasStation gasStation);

  List<User> findByGasStation(GasStation gasStation);

  List<TrustedGasStation> findByUser(User user);

  @Query(
      value = "select station_id from trusted_gas_station where user_email=?1",
      nativeQuery = true)
  List<Integer> findTrustedGasStationStationIdsByUserEmail(String email);
}
