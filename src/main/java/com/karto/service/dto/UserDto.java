package com.karto.service.dto;

import java.time.Instant;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class UserDto {

    String email;

    String username;

    String password;

    Instant createdAt;

    List<Integer> trustedGasStationIds;
}
