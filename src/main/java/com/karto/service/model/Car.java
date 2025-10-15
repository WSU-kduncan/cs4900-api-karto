package com.karto.service.model;

import java.time.Year;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "car")
public class Car {
    
    @Id
    @Column(name = "car_vin", columnDefinition="CHAR(17)", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String carVin;

    @JoinColumn(name = "user_email", nullable = false)
    @ManyToOne
    User user;

    @Column(name = "make", length = 20, nullable = false)
    String make;

    @Column(name = "year", columnDefinition="YEAR(4)", nullable = false)
    Year year;

    @Column(name = "initial_mileage", columnDefinition="MEDIUMINT", nullable = true)
    Integer initialMileage;

    @JoinColumn(name = "gas_type_id", nullable = false)
    @ManyToOne
    GasType gasType;
}