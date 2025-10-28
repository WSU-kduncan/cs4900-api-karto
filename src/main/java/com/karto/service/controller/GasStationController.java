package com.karto.service.controller;

import com.karto.service.dto.GasStationDto;
import com.karto.service.mapper.GasStationDtoMapper;
import com.karto.service.model.GasStation;
import com.karto.service.service.GasStationService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "gasstation", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class GasStationController {

  private final GasStationService gasStationService;
  private final GasStationDtoMapper gasStationDtoMapper;

  @GetMapping
  public ResponseEntity<List<GasStationDto>> getAllGasStations() {
    List<GasStation> stations = gasStationService.getAllGasStations();
    return new ResponseEntity<>(gasStationDtoMapper.toDtoList(stations), HttpStatus.OK);
  }

  @GetMapping(path = "{id}")
  public ResponseEntity<GasStationDto> getGasStationById(@PathVariable Integer id) {
    try {
      GasStation station = gasStationService.getGasStationById(id);
      return new ResponseEntity<>(gasStationDtoMapper.toDto(station), HttpStatus.OK);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(path = "search/{name}")
  public ResponseEntity<List<GasStationDto>> findGasStationsByName(@PathVariable String name) {
    List<GasStation> stations = gasStationService.findGasStationsByName(name);
    if (stations.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(gasStationDtoMapper.toDtoList(stations), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<GasStationDto> createGasStation(@RequestBody GasStationDto gasStationDto) {
    try {
      GasStation gasStation = gasStationDtoMapper.toEntity(gasStationDto);
      GasStation createdStation = gasStationService.createGasStation(gasStation);
      return new ResponseEntity<>(gasStationDtoMapper.toDto(createdStation), HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping(path = "{id}")
  public ResponseEntity<GasStationDto> updateGasStation(
      @PathVariable Integer id, @RequestBody GasStationDto gasStationDto) {
    try {
      GasStation gasStation = gasStationDtoMapper.toEntity(gasStationDto);
      GasStation updatedStation = gasStationService.updateGasStation(id, gasStation);
      return new ResponseEntity<>(gasStationDtoMapper.toDto(updatedStation), HttpStatus.OK);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
  }

}
