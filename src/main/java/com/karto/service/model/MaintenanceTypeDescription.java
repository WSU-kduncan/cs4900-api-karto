package com.karto.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "maintenance_type_description")
public class MaintenanceTypeDescription {

    @Id
    @Column(name = "maintenance_type_id", columnDefinition = "MEDIUMINT", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer typeId;

    @Column(name = "name", length = 30, nullable = false)
    String name;
}
