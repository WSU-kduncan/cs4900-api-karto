package com.karto.service.model;

import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
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
    String addressLine;

    @Column(name = "city", length = 63, nullable = false)
    String city;

    @Column(name = "state", length = 15, nullable = false)
    String state;

    @Column(name = "zip_code", length = 10, nullable = false)
    String zip;

    @ManyToMany(mappedBy = "trustedGasStations")
    Set<User> users;
}
