package com.karto.karto.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "maintenance_item_detail")
public class MaintenanceItemDetail {

    @Id
    @JoinColumn(name = "maintenance_type_id", nullable = false)
    @ManyToOne
    MaintenanceTypeDescription maintenanceTypeDescription;

    @Id
    @JoinColumn(name = "maintenance_id", nullable = false)
    @ManyToOne
    Maintenance maintenance;

    @Column(name = "quantity", columnDefinition = "TINYINT UNSIGNED", nullable = false)
    Integer quantity = 1;

    @Column(name = "comments", length = 255, nullable = false)
    String comments;
}
