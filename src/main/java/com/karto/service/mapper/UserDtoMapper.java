package com.karto.service.mapper;

import com.karto.service.dto.UserDto;
import com.karto.service.model.User;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {
  User toEntity(UserDto userDto) throws EntityNotFoundException;

  UserDto toDto(User user);

  List<UserDto> toDtoList(List<User> users);
}
