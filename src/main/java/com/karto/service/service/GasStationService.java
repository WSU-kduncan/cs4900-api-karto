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
}