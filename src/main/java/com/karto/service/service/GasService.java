package com.karto.service.service;

import com.karto.service.model.GasPrice;
import com.karto.service.repository.GasPriceRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GasService {
    private final GasPriceRepository gasPriceRepository;

    public List<GasPrice> getAllGasPrices() {
        return gasPriceRepository.findAll();
    }

    public GasPrice getGasPriceById(Integer id) throws EntityNotFoundException {
        var response = gasPriceRepository.findById(id);
        if (response.isEmpty())
            throw new EntityNotFoundException("Gas Price: ID " + id + " Not Found");
        return response.get();
    }

    public List<GasPrice> getGasPriceByGasStation(String stationName) {
        return gasPriceRepository.findByGasStationNameOrderByValue(stationName);
    }
}
