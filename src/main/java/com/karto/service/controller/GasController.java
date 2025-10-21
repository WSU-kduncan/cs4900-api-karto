package com.karto.service.controller;

import com.karto.service.dto.GasTypeDto;
import com.karto.service.mapper.GasTypeDtoMapper;
import com.karto.service.service.GasService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
