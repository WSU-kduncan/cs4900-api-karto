package com.karto.service.repository;

import java.util.List;
import java.util.Optional;

import com.karto.service.model.GasStation;
import com.karto.service.model.TrustedGasStation;
import com.karto.service.model.User;
import com.karto.service.model.composite.TrustedGasStationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrustedGasStationRepository extends JpaRepository<TrustedGasStation, TrustedGasStationId> {
    Optional<TrustedGasStation> findByUserAndGasStation(User user, GasStation gasStation);

    List<User> findByGasStation(GasStation gasStation);

    List<TrustedGasStation> findByUser(User user);

}
