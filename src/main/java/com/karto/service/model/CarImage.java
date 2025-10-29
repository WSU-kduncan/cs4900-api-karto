package com.karto.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "car_image")
public class CarImage {
  @Id
  String carVin;

  @OneToOne
  @EqualsAndHashCode.Exclude
  @MapsId
  @JoinColumn(name = "car_vin", columnDefinition = "CHAR(17)", nullable = false)
  Car car;

  @Column(name = "car_image", columnDefinition = "MEDIUMBLOB", nullable = false)
  byte[] image;
}
