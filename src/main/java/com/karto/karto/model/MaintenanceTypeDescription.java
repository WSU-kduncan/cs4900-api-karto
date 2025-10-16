package com.karto.karto.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "maintenance_type_description")
public class MaintenanceTypeDescription {

    @Id
    @Column(name = "maintenance_type_id", nullable = false)
    Integer maintenanceTypeId;

    @Column(name = "name", length = 30, nullable = false)
    String name;
}
