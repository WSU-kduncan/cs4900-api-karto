package com.karto.service.controller;

import com.karto.service.dto.GasPriceDto;
import com.karto.service.dto.GasTypeDto;
import com.karto.service.mapper.GasPriceDtoMapper;
import com.karto.service.mapper.GasTypeDtoMapper;
import com.karto.service.model.GasStation;
import com.karto.service.model.GasType;
import com.karto.service.model.User;
import com.karto.service.service.GasService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(
    path = "gas",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
public class GasController {
  private final GasService gasService;

  private final GasPriceDtoMapper gasPriceDtoMapper;
  private final GasTypeDtoMapper gasTypeDtoMapper;

  @GetMapping("types")
  ResponseEntity<List<GasTypeDto>> getAllGasTypes() {
    return new ResponseEntity<>(
        gasTypeDtoMapper.toDtoList(gasService.getAllGasTypes()), HttpStatus.OK);
  }

  @GetMapping("types/{id}")
  ResponseEntity<GasTypeDto> getGasTypeById(@PathVariable Integer id) {
    return new ResponseEntity<>(
        gasTypeDtoMapper.toDto(gasService.getGasTypeById(id)), HttpStatus.OK);
  }

  @GetMapping("types/name/{name}")
  ResponseEntity<GasTypeDto> getGasTypeByName(@PathVariable String name) {
    return new ResponseEntity<>(
        gasTypeDtoMapper.toDto(gasService.getGasTypeByName(name)), HttpStatus.OK);
  }

  @PostMapping("types")
  ResponseEntity<Object> createGasType(@RequestBody GasTypeDto gasTypeDto) {
    GasType gasType;

    try {
      gasType = gasService.createGasType(gasTypeDto);

      return new ResponseEntity<>(gasTypeDtoMapper.toDto(gasType), HttpStatus.CREATED);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * Gas Prices
   */
  @GetMapping(path = "prices")
  ResponseEntity<List<GasPriceDto>> getAllGasPrices() {
    try {
      return new ResponseEntity<>(
          gasPriceDtoMapper.toDtoList(gasService.getAllGasPrices()), HttpStatus.OK);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Get gas price by gas station and gas type
   * @param stationId
   * @param typeId
   * @return
   */
  @GetMapping(path = "price/gasStation/{stationId}/gasType/{typeId}")
  ResponseEntity<GasPriceDto> getGasPriceById(
      @PathVariable Integer stationId, @PathVariable Integer typeId) {
    try {
      GasStation gasStation = gasService.getGasStationById(stationId);
      GasType gasType = gasService.getGasTypeById(typeId);
      var gasPrice = gasService.getGasPriceById(gasStation, gasType);
      return new ResponseEntity<>(gasPriceDtoMapper.toDto(gasPrice), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(path = "prices/{gasType}")
  ResponseEntity<List<GasPriceDto>> getGasPriceByGasType(@PathVariable String gasType) {
    try {
      return new ResponseEntity<>(
          gasPriceDtoMapper.toDtoList(gasService.getGasPriceByGasType(gasType)), HttpStatus.OK);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Get trusted gas stations
   * @param stationId
   * @return
   */
  @GetMapping(path = "station/{stationId}/users")
  ResponseEntity<List<User>> getUsersByTrustedGasStation(@PathVariable Integer stationId) {
    try {
      GasStation gasStation = gasService.getGasStationById(stationId);
      return new ResponseEntity<>(gasService.getUsersByGasStation(gasStation), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
