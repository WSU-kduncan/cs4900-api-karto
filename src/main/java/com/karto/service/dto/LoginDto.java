package com.karto.service.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@Value
@Builder
public class LoginDto {
  String email;
  String password;
}
