package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;
import lombok.Data;

@Data
@Entity
@Table(name = "gas_station")
public class GasStation {

  @Id
  @Column(name = "station_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @Column(name = "longitude", columnDefinition = "DECIMAL(9,6)", nullable = false)
  BigDecimal longitude;

  @Column(name = "latitude", columnDefinition = "DECIMAL(8,6)", nullable = false)
  BigDecimal latitude;

  @Column(name = "name", length = 25, nullable = false)
  String name;

  @Column(name = "address_line", length = 63, nullable = false)
  String addres;

  @Column(name = "city", length = 63, nullable = false)
  String city;

  @Column(name = "state", length = 13, nullable = false)
  String state;

  @Column(name = "zip", length = 10, nullable = false)
  String zip;

  @ManyToMany(mappedBy = "trustedGasStation")
  Set<User> users;
}
