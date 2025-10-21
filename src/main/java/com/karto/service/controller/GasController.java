package com.karto.service.controller;

import java.util.List;

import com.karto.service.dto.GasPriceDto;
import com.karto.service.mapper.GasPriceDtoMapper;
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

    @GetMapping("prices")
    ResponseEntity<List<GasPriceDto>> getAllGasPrices() {
        return new ResponseEntity<>(gasPriceDtoMapper.toDtoList(gasService.getAllGasPrices()),
                HttpStatus.OK);
    }

    @GetMapping("{id}")
    ResponseEntity<GasPriceDto> getGasPriceById(@PathVariable Integer id) {
        try {
            var gasPrice = gasService.getGasPriceById(id);
            return new ResponseEntity<>(gasPriceDtoMapper.toDto(gasPrice), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("stations/{stationName}")
    ResponseEntity<List<GasPriceDto>> getGasPriceByGasStation(@PathVariable String stationName) {
        return new ResponseEntity<>(
                gasPriceDtoMapper.toDtoList(gasService.getGasPriceByGasStation(stationName)),
                HttpStatus.OK);
    }
}
