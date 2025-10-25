package com.karto.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.Year;
import lombok.Data;

@Data
@Entity
@Table(name = "car")
public class Car {
  @Id
  @Column(name = "car_vin", columnDefinition = "CHAR(17)", length = 17, nullable = false)
  String vin;

  @OneToOne(mappedBy = "car")
  CarImage image;

  @JoinColumn(name = "user_email", nullable = false)
  @ManyToOne
  User user;

  @Column(name = "make", length = 20, nullable = false)
  String make;

  @Column(name = "model", length = 40, nullable = false)
  String model;

  @Column(name = "year", columnDefinition = "YEAR", nullable = false)
  Year year;

  @Column(name = "color", length = 15)
  String color;

  @Column(name = "initial_mileage", columnDefinition = "MEDIUM UNSIGNED")
  Integer mileage;

  @JoinColumn(name = "gas_type_id", columnDefinition = "SMALLINT UNSIGNED", nullable = false)
  @ManyToOne
  GasType gasType;
}
