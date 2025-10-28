package com.karto.service.controller;

import com.karto.service.dto.UserDto;
import com.karto.service.mapper.UserDtoMapper;
import com.karto.service.model.GasStation;
import com.karto.service.model.User;
import com.karto.service.service.UserService;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

import org.apache.catalina.connector.Response;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(path = "user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
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

  @PostMapping()
  public ResponseEntity<Object> createUser(@RequestBody UserDto userDto) {
    try {
      User user = userDtoMapper.toEntity(userDto);
      User createdUser = userService.createUser(user);
      return new ResponseEntity<>(userDtoMapper.toDto(createdUser), HttpStatus.CREATED);
    } catch (IllegalArgumentException e) {
      return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping("{email}")
  public ResponseEntity<Object> updateUser(@PathVariable String email, @RequestBody UserDto userDto) {
    try {
      User user = userDtoMapper.toEntity(userDto);
      User updatedUser = userService.updateUser(email, user);
      return new ResponseEntity<>(userDtoMapper.toDto(updatedUser), HttpStatus.OK);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}
