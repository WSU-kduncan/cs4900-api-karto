package com.karto.service.service;

import com.karto.service.model.GasPrice;
import com.karto.service.model.GasStation;
import com.karto.service.model.GasType;
import com.karto.service.model.composite.GasPriceId;
import com.karto.service.repository.GasPriceRepository;

import com.karto.service.repository.GasStationRepository;
import com.karto.service.repository.GasTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GasService {
    private final GasPriceRepository gasPriceRepository;

    private final GasStationRepository gasStationRepository;

    private final GasTypeRepository gasTypeRepository;

    public List<GasPrice> getAllGasPrices() {
        return gasPriceRepository.findAll();
    }

    public GasStation getGasStationById(Integer id) {
        var response = gasStationRepository.findById(id);
        if (response.isEmpty())
            throw new EntityNotFoundException("Gas Station: ID " + id + " Not Found");
        return response.get();
    }

    public GasType  getGasTypeById(Integer id) {
        var response = gasTypeRepository.findById(id);
        if (response.isEmpty())
            throw new EntityNotFoundException("Gas Type: ID " + id + " Not Found");
        return response.get();
    }

    public GasPrice getGasPriceById(GasPriceId id) throws EntityNotFoundException {
        var response = gasPriceRepository.findById(id);
        if (response.isEmpty())
            throw new EntityNotFoundException("Gas Price: ID " + id + " Not Found");
        return response.get();
    }

    public List<GasPrice> getGasPriceByGasType(String gasType) {
        return gasPriceRepository.findById_GasType_Name(gasType);
    }
}
