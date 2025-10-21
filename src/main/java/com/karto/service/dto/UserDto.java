package com.karto.service.dto;

import java.time.Instant;
import java.util.Set;

import lombok.Data;

@Data
public class UserDto {

    private String email;
    private String username;
    private Instant createdAt;

    private Set<Integer> trustedGasStationIds;
}
