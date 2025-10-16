package com.karto.karto.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "maintenance_item_detail")
public class MaintenanceItemDetail {

    @Id
    @JoinColumns({
            @JoinColumn(name = "maintenance_type_id", columnDefinition = "INT UNSIGNED", nullable = false),
            @JoinColumn(name = "maintenance_type_id", columnDefinition = "MEDIUMINT UNSIGNED", nullable = false)
    })
    @OneToOne
    MaintenanceTypeDescription maintenanceTypeDescription;

    @Column(name = "quantity", columnDefinition = "TINYINT UNSIGNED", nullable = false)
    Integer quantity = 1;

    @Column(name = "comments", length = 255, nullable = false)
    String comments;
}
