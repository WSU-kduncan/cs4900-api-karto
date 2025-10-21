package com.karto.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "gas_type")
public class GasType {
  @Id
  @Column(name = "gas_type_id", columnDefinition = "SMALLINT UNSIGNED", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @Column(name = "name", length = 15, nullable = false)
  String name;
}
