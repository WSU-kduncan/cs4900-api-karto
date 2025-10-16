package com.karto.service.model;

import java.math.BigDecimal;
import java.time.Instant;

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
@Table(name = "maintenance")
public class Maintenance {

    @Id
    @Column(name = "maintenance_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer maintenanceId;

    @JoinColumn(name = "car_vin", nullable = false)
    @ManyToOne
    Car car;

    @Column(name = "maintenance_datetime", nullable = false)
    Instant datetime;

    @Column(name = "mileage", columnDefinition = "MEDIUMINT UN", nullable = false)
    Integer mileage;

    @Column(name = "cost", columnDefinition = "DECIMAL(7, 4)", nullable = false)
    BigDecimal cost;
}