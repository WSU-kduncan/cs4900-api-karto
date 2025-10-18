package com.karto.service.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.karto.service.model.GasType;
import com.karto.service.repository.GasTypeRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GasService {

    private final GasTypeRepository gasTypeRepository;

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
}
