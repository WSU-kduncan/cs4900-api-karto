package com.karto.service.controller;

import java.util.List;

import com.karto.service.mapper.UserDtoMapper;
import com.karto.service.model.GasStation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karto.service.dto.UserDto;
import com.karto.service.model.User;
import com.karto.service.service.UserService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(
        path = "user",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;
    private final UserDtoMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(userMapper.toDtoList(users), HttpStatus.OK);
    }

    @GetMapping(path = "{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {
        try {
            User user = userService.getUserByEmail(email);
            return new ResponseEntity<>(userMapper.toDto(user), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "username/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username) {
        try {
            User user = userService.getUserByUsername(username);
            return new ResponseEntity<>(userMapper.toDto(user), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "{email}/trustedStations")
    public ResponseEntity<?> getAllTrustedStationsByEmail(@PathVariable String email) {
        try {
            User user = userService.getUserByEmail(email);
            var trustedStations = user.getTrustedGasStations();
            for (GasStation gasStation : trustedStations) {
                System.out.println(gasStation.getName());
            }
            return ResponseEntity.ok(trustedStations);
        } catch (EntityNotFoundException enfe) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}