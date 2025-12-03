package com.karto.service.mapper;

import com.karto.service.dto.CarDto;
import com.karto.service.model.Car;
import com.karto.service.service.CarService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

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
  @Mapping(source = "gasTypeId", target = "gasType.id")
  Car updateEntity(CarDto carDto, @MappingTarget Car car) throws EntityNotFoundException;
}
