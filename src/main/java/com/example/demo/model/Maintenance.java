package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;
import lombok.Data;

@Data
@Entity
@Table(name = "maintenance")
public class Maintenance {

  @Id
  @Column(name = "maintenance_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer maintenanceId;

  @JoinColumn(name = "car_vin", nullable = false)
  @ManyToOne
  Integer vin;

  @Column(name = "maintenance_datetime", nullable = false)
  Instant maintenanceDate;

  @Column(name = "mileage", columnDefinition = "MEDIUMINT UNSIGNED")
  Integer mileage;

  @Column(name = "cost", columnDefinition = "DECIMAL(7,4) UNSIGNED")
  BigDecimal cost;
}
