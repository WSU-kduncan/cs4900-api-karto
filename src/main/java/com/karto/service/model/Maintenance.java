package com.karto.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

import lombok.Data;

@Entity
@Data
@Table(name = "maintenance")
public class Maintenance {
  @Id
  @Column(name = "maintenance_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @JoinColumn(name = "car_vin", nullable = false)
  @ManyToOne
  Car car;

  @Column(name = "maintenance_datetime", nullable = false)
  Instant date;

  @Column(name = "mileage", columnDefinition = "MEDIUMINT UNSIGNED")
  Integer mileage;

  @Column(name = "cost", columnDefinition = "DECIMAL(7,4) UNSIGNED")
  BigDecimal cost;

  @OneToMany(mappedBy = "id.maintenance")
  Set<MaintenanceItemDetail> itemDetails;

  @OneToOne(mappedBy = "maintenance")
  MaintenanceReceipt receipt;

}
