package com.example.demo.model;

import com.example.demo.model.User;
import com.example.demo.model.GasType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.Year;
import lombok.Data;

@Data
@Entity
@Table(name = "car")
public class Car {

  @Id
  @Column(name = "car_vin", columnDefinition = "CHAR(17)", length = 17, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  String vin;

  @JoinColumn(name = "user_email", nullable = false)
  @ManyToOne
  User user;

  @Column(name = "make", length = 20, nullable = false)
  String make;

  @Column(name = "model", length = 40, nullable = false)
  String model;

  @Column(name = "year", columnDefinition = "YEAR", nullable = false)
  Year year;

  @Column(name = "color", length = 15, nullable = false)
  String color;

  @Column(name = "initial_mileage", columnDefinition = "MEDIUM UNSIGNED")
  Integer mileage;

  @JoinColumn(name = "gas_type_id", columnDefinition = "SMALLINT UNSIGNED", nullable = false)
  @ManyToOne
  GasType gasType;
}
