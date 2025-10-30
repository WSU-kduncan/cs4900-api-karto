package com.karto.service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.karto.service.model.GasStation;
import com.karto.service.repository.GasStationRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GasStationService {

  private final GasStationRepository gasStationRepository;

  public List<GasStation> getAllGasStations() {
    return gasStationRepository.findAll();
  }

  public GasStation getGasStationById(Integer id) throws EntityNotFoundException {
    Optional<GasStation> station = gasStationRepository.findById(id);
    if (station.isEmpty()) {
      throw new EntityNotFoundException("GasStation not found with id: " + id);
    }
    return station.get();
  }

  public List<GasStation> findGasStationsByName(String name) {
    return gasStationRepository.findByNameContainingIgnoreCase(name);
  }

  public GasStation createGasStation(GasStation gasStation) {
    return gasStationRepository.saveAndFlush(gasStation);
  }

  public GasStation updateGasStation(Integer id, GasStation gasStation) {
    GasStation existingStation = gasStationRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("GasStation not found with id: " + id));

    existingStation.setName(gasStation.getName());
    existingStation.setLongitude(gasStation.getLongitude());
    existingStation.setLatitude(gasStation.getLatitude());
    existingStation.setAddressLine(gasStation.getAddressLine());
    existingStation.setCity(gasStation.getCity());
    existingStation.setState(gasStation.getState());
    existingStation.setZip(gasStation.getZip());

    return gasStationRepository.saveAndFlush(existingStation);
  }

  public void deleteGasStation(Integer id) {
    if (!gasStationRepository.existsById(id)) {
      throw new EntityNotFoundException("Gas station not found with: " + id);
    }
    gasStationRepository.deleteById(id);
  }
}
