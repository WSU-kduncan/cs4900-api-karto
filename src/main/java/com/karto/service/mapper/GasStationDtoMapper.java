package com.karto.service.mapper;

import com.karto.service.dto.GasStationDto;
import com.karto.service.model.GasStation;
import com.karto.service.model.User;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface GasStationDtoMapper {

  GasStation toEntity(GasStationDto gasStationDto) throws EntityNotFoundException;

  GasStationDto toDto(GasStation gasStation);

  List<GasStationDto> toDtoList(List<GasStation> gasStations);

  @Named("usersToEmails")
  default List<String> usersToEmails(List<User> users) {
    if (users == null) {
      return null;
    }
    return users.stream().map(User::getEmail).collect(Collectors.toList());
  }
}
