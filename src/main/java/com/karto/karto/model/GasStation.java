package com.karto.karto.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "gas_station")
public class GasStation {

    @Id
    @Column(name = "station_id", columnDefinition = "INT UNSIGNED", nullable = false)
    Integer stationId;

    @Column(name = "longitude", columnDefinition = "DECIMAL(9, 6)", nullable = false)
    Long longitude;

    @Column(name = "latitude", columnDefinition = "DECIMAL(8, 6)", nullable = false)
    Long latitude;

    @Column(name = "name", length = 25, nullable = false)
    String name;

    @Column(name = "address_line", length = 63, nullable = false)
    String addressLine;

    @Column(name = "city", length = 63, nullable = false)
    String city;

    @Column(name = "state", length = 13, nullable = false)
    String state;

    @Column(name = "zip", length = 10, nullable = false)
    String zip;
}
