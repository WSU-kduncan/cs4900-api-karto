package com.karto.service.mapper;

import com.karto.service.dto.CarDto;
import com.karto.service.model.Car;
import com.karto.service.service.CarService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(
    componentModel = "spring",
    uses = {CarService.class})
public interface CarDtoMapper {

  @Mapping(source = "image", target = "image.image")
  @Mapping(source = "vin", target = "image.carVin")
  @Mapping(source = "userEmail", target = "user.email")
  Car toEntity(CarDto carDto) throws EntityNotFoundException;

  @Mapping(source = "image.image", target = "image")
  @Mapping(source = "user.email", target = "userEmail")
  CarDto toDto(Car car) throws EntityNotFoundException;

  List<CarDto> toDtoList(List<Car> carList) throws EntityNotFoundException;

  @InheritConfiguration
  Car updateEntity(CarDto carDto, @MappingTarget Car car) throws EntityNotFoundException;
}
