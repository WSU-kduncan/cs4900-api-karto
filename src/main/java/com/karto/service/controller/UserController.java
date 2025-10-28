package com.karto.service.controller;

import com.karto.service.dto.UserDto;
import com.karto.service.mapper.UserDtoMapper;
import com.karto.service.model.GasStation;
import com.karto.service.model.User;
import com.karto.service.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "user", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;
  private final UserDtoMapper userDtoMapper;

  @GetMapping
  public ResponseEntity<List<UserDto>> getAllUsers() {
    try {
      List<User> users = userService.getAllUsers();
      return new ResponseEntity<>(userDtoMapper.toDtoList(users), HttpStatus.OK);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(path = "{email}")
  public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {
    try {
      User user = userService.getUserByEmail(email);
      return new ResponseEntity<>(userDtoMapper.toDto(user), HttpStatus.OK);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(path = "username/{username}")
  public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username) {
    try {
      User user = userService.getUserByUsername(username);
      return new ResponseEntity<>(userDtoMapper.toDto(user), HttpStatus.OK);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(path = "{email}/trustedStations")
  public ResponseEntity<List<GasStation>> getTrustedGasStationsByUser(@PathVariable String email) {
    try {
      User user = userService.getUserByEmail(email);
      return new ResponseEntity<>(userService.getGasStationByUser(user), HttpStatus.OK);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

//  @PostMapping
//  ResponseEntity<Object> createTrustedGasStation(@RequestBody Trustedgasstation workOrderRequestDto) {
//      WorkOrder workOrder;
//      try {
//          workOrder = workOrderService.createWorkOrderRequest(workOrderRequestDto);
//      } catch (EntityNotFoundException e) {
//          return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
//      }
//      return new ResponseEntity<>(workOrder, HttpStatus.OK);
//  }
}
