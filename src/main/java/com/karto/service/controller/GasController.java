package com.karto.service.controller;

import com.karto.service.dto.GasPriceDto;
import com.karto.service.mapper.GasPriceDtoMapper;
import com.karto.service.model.GasPrice;
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
import org.springframework.web.bind.annotation.PutMapping;
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

  @PostMapping
  ResponseEntity<Object> saveGasPrice(@RequestBody GasPriceDto gasPriceDto) {
    GasPrice gasPrice;
    try {
      var dto = gasPriceDtoMapper.toEntity(gasPriceDto);
      gasPrice = gasService.saveGasPrice(dto);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(gasPriceDtoMapper.toDto(gasPrice), HttpStatus.OK);
  }

  @PutMapping(path = "price/{station}/{type}")
  ResponseEntity<Object> updateGasPrice(
      @PathVariable Integer station,
      @PathVariable Integer type,
      @RequestBody GasPriceDto gasPriceDto) {
    GasPrice gasPrice;
    try {
      gasPrice = gasService.putGasPrice(station, type, gasPriceDto);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(gasPrice, HttpStatus.OK);
  }

  @GetMapping(path = "prices")
  ResponseEntity<List<GasPriceDto>> getAllGasPrices() {
    try {
      return new ResponseEntity<>(
          gasPriceDtoMapper.toDtoList(gasService.getAllGasPrices()), HttpStatus.OK);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(path = "{gasType}")
  ResponseEntity<List<GasPriceDto>> getGasPriceByGasType(@PathVariable String gasType) {
    try {
      return new ResponseEntity<>(
          gasPriceDtoMapper.toDtoList(gasService.getGasPriceByGasType(gasType)), HttpStatus.OK);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
