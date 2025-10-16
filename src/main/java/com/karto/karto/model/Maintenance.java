package com.karto.karto.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

@Data
@Entity
@Table(name = "maintenance")
public class Maintenance {

    @Id
    @Column(name = "maintenance_id", unique = true, columnDefinition = "INT UNSIGNED", nullable = false)
    Integer maintenanceId;

    @Id
    @JoinColumn(name = "car_vin")
    @ManyToOne
    Car car;

    @Column(name = "maintenance_datetime", nullable = false)
    @CreationTimestamp(source = SourceType.DB)
    Instant maintenanceDatetime;

    @Column(name = "mileage", columnDefinition = "MEDIUMINT UNSIGNED")
    Integer initialMileage;

    @Column(name = "cost", columnDefinition = "DECIMAL(7, 4) UNSIGNED")
    Long cost;
}
