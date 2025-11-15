package com.karto.service.controller;

import com.karto.service.dto.MaintenanceDto;
import com.karto.service.mapper.MaintenanceDtoMapper;
import com.karto.service.service.MaintenanceService;
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
@RequestMapping(path = "maintenance", produces = MediaType.APPLICATION_JSON_VALUE)
public class MaintenanceController {
  private final MaintenanceService maintenanceService;

  private final MaintenanceDtoMapper maintenanceDtoMapper;

  @GetMapping("all")
  ResponseEntity<List<MaintenanceDto>> getAllMaintenanceLogs() {
    return new ResponseEntity<>(
        maintenanceDtoMapper.toDtoList(maintenanceService.getAllMaintenance()), HttpStatus.OK);
  }

  @GetMapping("{id}")
  ResponseEntity<MaintenanceDto> getMaintenanceById(@PathVariable Integer id) {
    try {
      var maintenance = maintenanceService.getMaintenanceById(id);
      return new ResponseEntity<>(maintenanceDtoMapper.toDto(maintenance), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("car/{carVin}")
  ResponseEntity<List<MaintenanceDto>> getMaintenanceByCar(@PathVariable String carVin) {
    return new ResponseEntity<>(
        maintenanceDtoMapper.toDtoList(maintenanceService.getAllMaintenanceByCar(carVin)),
        HttpStatus.OK);
  }

  @PostMapping
  ResponseEntity<Object> postMaintenance(@RequestBody MaintenanceDto maintenanceDto) {
    try {
      var maintenance = maintenanceService.createMaintenance(maintenanceDto);
      return new ResponseEntity<>(maintenanceDtoMapper.toDto(maintenance), HttpStatus.CREATED);
    } catch (EntityNotFoundException e) {
      return ResponseEntity.badRequest().body(e.getLocalizedMessage());
    }
  }

  @PutMapping("{id}")
  ResponseEntity<Object> putMaintenance(
      @PathVariable Integer id, @RequestBody MaintenanceDto maintenanceDto) {
    try {
      var maintenance = maintenanceService.putMaintenance(id, maintenanceDto);
      return new ResponseEntity<>(maintenanceDtoMapper.toDto(maintenance), HttpStatus.CREATED);
    } catch (EntityNotFoundException e) {
      return ResponseEntity.badRequest().body(e.getLocalizedMessage());
    }
  }
}
