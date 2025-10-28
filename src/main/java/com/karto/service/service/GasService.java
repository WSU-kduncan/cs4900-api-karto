package com.karto.service.service;

import com.karto.service.dto.GasPriceDto;
import com.karto.service.dto.GasPriceIdDto;
import com.karto.service.dto.GasTypeDto;
import com.karto.service.mapper.GasPriceDtoMapper;
import com.karto.service.mapper.GasPriceIdDtoMapper;
import com.karto.service.mapper.GasTypeDtoMapper;
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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GasService {

  private final GasTypeRepository gasTypeRepository;

  private final GasTypeDtoMapper gasTypeDtoMapper;

  private final GasStationRepository gasStationRepository;

  private final TrustedGasStationRepository trustedGasStationRepository;

  private final GasPriceRepository gasPriceRepository;

  private final GasPriceDtoMapper gasPriceDtoMapper;

  private final GasPriceIdDtoMapper gasPriceIdDtoMapper;

  public List<GasType> getAllGasTypes() throws EntityNotFoundException {
    return gasTypeRepository.findAll();
  }

  public GasPrice saveGasPrice(GasPrice gasPrice) throws EntityNotFoundException {
    return gasPriceRepository.saveAndFlush(gasPrice);
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

  public GasPrice putGasPrice(Integer gasStation, Integer gasType, GasPriceDto gasPriceDto)
      throws EntityNotFoundException {
    var gasPriceIdDto =
        GasPriceIdDto.builder().gasStationId(gasStation).gasTypeId(gasType).build();
    var gasPriceIdEntity = gasPriceIdDtoMapper.toEntity(gasPriceIdDto);

    GasPrice gasPrice = gasPriceRepository
        .findById(gasPriceIdEntity)
        .orElseThrow(
            () -> new EntityNotFoundException("Work Order (" + gasPriceIdEntity + ") not found"));

    gasPriceDtoMapper.updateEntity(gasPriceDto, gasPrice);

    return gasPriceRepository.saveAndFlush(gasPrice);
  }

  public List<User> getUsersByGasStation(GasStation gasStation) {
    return trustedGasStationRepository.findByGasStation(gasStation);
  }

  public List<GasPrice> getGasPriceByGasType(String gasType) {
    return gasPriceRepository.findById_GasType_Name(gasType);
  }

  public GasPrice getGasPriceById(GasStation gasStation, GasType gasType)
      throws EntityNotFoundException {
    var response = gasPriceRepository.findByIdStationAndIdGasType(gasStation, gasType);
    if (response.isEmpty())
      throw new EntityNotFoundException("Gas Price: Station " + gasStation.getId() + " or Type: "
          + gasType.getId() + " Not Found");
    return response.get();
  }

  public GasType createGasType(GasTypeDto gasTypeDto) throws EntityNotFoundException {
    // Check if gas type with the same name already exists
    Optional<GasType> existingGasType = gasTypeRepository.findByName(gasTypeDto.getName());
    if (existingGasType.isPresent()) {
      throw new DataIntegrityViolationException(
          "GasType with name " + gasTypeDto.getName() + " already exists.");
    }

    return gasTypeRepository.saveAndFlush(gasTypeDtoMapper.toEntity(gasTypeDto));
  }

  public GasType putGasType(Integer id, GasTypeDto gasTypeDto) throws EntityNotFoundException {
    GasType existingGasType = gasTypeRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("GasType with id " + id + " not found."));

    if (gasTypeDto.getId() != existingGasType.getId()) {
      throw new IllegalStateException("GasType ID in path and request body do not match: " + id
          + " != " + gasTypeDto.getId() + ". Cannot change ID of existing GasType.");
    }
    existingGasType.setName(gasTypeDto.getName());

    return gasTypeRepository.saveAndFlush(existingGasType);
  }
}
