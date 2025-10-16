package com.karto.karto.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.Year;

@Data
@Entity
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "car_vin", length = 17, nullable = false)
    String carVin;

    @JoinColumn(name = "user_email", nullable = false)
    @ManyToOne
    User user;

    @Column(name = "make", length = 20, nullable = false)
    String make;

    @Column(name = "model", length = 40, nullable = false)
    String model;

    @Column(name = "year", length = 4, nullable = false)
    Year year;

    @Column(name = "color", length = 15)
    String color;

    @Column(name = "initial_mileage", columnDefinition = "MEDIUMINT UNSIGNED")
    Integer initialMileage;

    @JoinColumn(name = "gas_type_id", columnDefinition = "SMALLINT UNSIGNED", nullable = false)
    @ManyToOne
    GasType gasType;
}
