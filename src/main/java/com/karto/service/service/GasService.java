package com.karto.service.service;

import com.karto.service.model.GasPrice;
import com.karto.service.model.GasStation;
import com.karto.service.model.GasType;
import com.karto.service.model.User;
import com.karto.service.repository.GasPriceRepository;
import com.karto.service.repository.GasStationRepository;
import com.karto.service.repository.GasTypeRepository;
import com.karto.service.repository.TrustedGasStationRepository;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GasService {

  private final GasTypeRepository gasTypeRepository;

  private final GasStationRepository gasStationRepository;

  private final TrustedGasStationRepository trustedGasStationRepository;

  private final GasPriceRepository gasPriceRepository;

  public List<GasType> getAllGasTypes() throws EntityNotFoundException {
    return gasTypeRepository.findAll();
  }

  public List<GasPrice> getAllGasPrices() {
    return gasPriceRepository.findAll();
  }

  public GasStation getGasStationById(Integer id) {
    var response = gasStationRepository.findById(id);
    if (response.isEmpty())
      throw new EntityNotFoundException("Gas Station: ID " + id + " Not Found");
    return response.get();
  }

  public GasType getGasTypeById(Integer id) throws EntityNotFoundException {
    Optional<GasType> response = gasTypeRepository.findById(id);

    if (response.isEmpty()) {
      throw new EntityNotFoundException("GasType with id " + id + " not found.");
    }

    return response.get();
  }

  public GasType getGasTypeByName(String name) throws EntityNotFoundException {
    Optional<GasType> response = gasTypeRepository.findByName(name);

    if (response.isEmpty()) {
      throw new EntityNotFoundException("GasType with name " + name + " not found.");
    }

    return response.get();
  }

  public List<User> getUsersByGasStation(GasStation gasStation) {
    return trustedGasStationRepository.findByGasStation(gasStation);
  }

  public List<GasPrice> getGasPriceByGasType(String gasType) {
    return gasPriceRepository.findById_GasType_Name(gasType);
  }
}
