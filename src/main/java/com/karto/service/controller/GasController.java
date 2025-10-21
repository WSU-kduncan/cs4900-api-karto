package com.karto.service.controller;

import java.util.List;

import com.karto.service.dto.GasPriceDto;
import com.karto.service.mapper.GasPriceDtoMapper;
import com.karto.service.model.GasStation;
import com.karto.service.model.GasType;
import com.karto.service.service.GasService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(
        path = "gas",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class GasController {
    private final GasService gasService;

    private final GasPriceDtoMapper gasPriceDtoMapper;

    @GetMapping(path = "prices")
    ResponseEntity<List<GasPriceDto>> getAllGasPrices() {
        return new ResponseEntity<>(
                gasPriceDtoMapper.toDtoList(gasService.getAllGasPrices()),
                HttpStatus.OK);
    }

    @GetMapping(path = "price/gasStation/{stationId}/gasType/{typeId}")
    ResponseEntity<GasPriceDto> getGasPriceById(@PathVariable Integer stationId, @PathVariable Integer typeId) {
        try {
            GasStation gasStation = gasService.getGasStationById(stationId);
            GasType gasType = gasService.getGasTypeById(typeId);
            var gasPrice = gasService.getGasPriceById(gasStation, gasType);
            return new ResponseEntity<>(gasPriceDtoMapper.toDto(gasPrice), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "{gasType}")
    ResponseEntity<List<GasPriceDto>> getGasPriceByGasType(@PathVariable String gasType) {
        return new ResponseEntity<>(
                gasPriceDtoMapper.toDtoList(gasService.getGasPriceByGasType(gasType)),
                HttpStatus.OK);
    }
}
