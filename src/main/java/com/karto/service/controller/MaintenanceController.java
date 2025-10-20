package com.karto.service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karto.service.dto.MaintenanceDto;
import com.karto.service.mapper.MaintenanceDtoMapper;
import com.karto.service.service.MaintenanceService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "maintenance", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class MaintenanceController {
    private final MaintenanceService maintenanceService;

    private final MaintenanceDtoMapper maintenanceDtoMapper;

    @GetMapping("all")
    ResponseEntity<List<MaintenanceDto>> getAllMaintenanceLogs() {
        return new ResponseEntity<>(maintenanceDtoMapper.toDtoList(maintenanceService.getAllMaintenance()),
                HttpStatus.OK);
    }

    @GetMapping("{id}")
    ResponseEntity<MaintenanceDto> getMaintenanceById(Integer id) {
        try {
            var maintenance = maintenanceService.getMaintenanceById(id);
            return new ResponseEntity<>(maintenanceDtoMapper.toDto(maintenance), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("car/{id}")
    ResponseEntity<List<MaintenanceDto>> getMaintenanceByCar(String carVin) {
        return new ResponseEntity<>(maintenanceDtoMapper.toDtoList(maintenanceService.getAllMaintenanceByCar(carVin)),
                HttpStatus.OK);
    }
}
