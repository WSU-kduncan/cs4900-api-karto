package com.karto.service.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.karto.service.dto.CarDto;
import com.karto.service.model.Car;
import com.karto.service.service.CarService;

import jakarta.persistence.EntityNotFoundException;

@Mapper(
    componentModel = "spring",
    uses = {CarService.class})
public interface CarDtoMapper {

  @Mapping(source = "image", target = "image.image")
  @Mapping(source = "userEmail", target = "user.email")
  @Mapping(source = "gasTypeId", target = "gasType.id")
  Car toEntity(CarDto carDto) throws EntityNotFoundException;

  @AfterMapping
  default void addDependentFields(@MappingTarget Car car) {
    if (car.getImage() != null) {
      car.getImage().setCar(car);
    } else {
      car.setImage(null);
    }
  }

  @Mapping(source = "image.image", target = "image")
  @Mapping(source = "user.email", target = "userEmail")
  @Mapping(source = "gasType.id", target = "gasTypeId")
  CarDto toDto(Car car) throws EntityNotFoundException;

  List<CarDto> toDtoList(List<Car> carList) throws EntityNotFoundException;

  @Mapping(source = "image", target = "image.image")
  @Mapping(source = "userEmail", target = "user.email")
  // When updating an existing Car entity we must not let MapStruct change the identifier
  // of the associated GasType (that would attempt to alter a managed entity's id). The
  // service layer will load and set the managed GasType instance after mapping.
  @Mapping(target = "gasType", ignore = true)
  Car updateEntity(CarDto carDto, @MappingTarget Car car) throws EntityNotFoundException;
}
