package com.karto.service.mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.karto.service.dto.UserDto;
import com.karto.service.model.GasStation;
import com.karto.service.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "trustedGasStations", target = "trustedGasStationIds", qualifiedByName = "gasStationsToIds")
    UserDto toDto(User user);

    List<UserDto> toDtoList(List<User> users);

    @Named("gasStationsToIds")
    default List<Integer> gasStationsToIds(List<GasStation> stations) {
        if (stations == null) {
            return null;
        }
        return stations.stream().map(GasStation::getId).collect(Collectors.toList());
    }
}