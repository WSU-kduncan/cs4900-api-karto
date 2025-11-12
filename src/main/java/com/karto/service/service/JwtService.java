package com.karto.service.service;

import com.karto.service.dto.UserDto;
import com.karto.service.mapper.UserDtoMapper;
import com.karto.service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final UserDtoMapper userDtoMapper;

  public com.karto.service.model.User addUser(UserDto userDto) throws Exception {
    if (userRepository.existsById(userDto.getEmail())) throw new Exception("Duplicate Email");
    if (userRepository.existsByUsername(userDto.getUsername()))
      throw new Exception("Duplicate Username");
    var entity = userDtoMapper.toEntity(userDto);
    entity.setPassword(passwordEncoder.encode(entity.getPassword()));
    var back = userRepository.saveAndFlush(entity);
    return back;
  }
}
