package com.karto.service.dto;

import java.time.Instant;
import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class UserDto {

    private String email;
    private String username;
    private Instant createdAt;

    private List<Integer> trustedGasStationIds;
}
