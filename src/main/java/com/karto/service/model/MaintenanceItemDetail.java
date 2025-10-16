package com.karto.service.model;

import com.karto.service.model.composite.MaintenanceItemDetailId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "maintenance_item_detail")
public class MaintenanceItemDetail {

    @EmbeddedId
    MaintenanceItemDetailId id;

    @Column(name = "quantity", columnDefinition = "TINYINT UNSIGNED", nullable = false)
    Integer quantity;

    @Column(name = "comments", length = 255)
    String comments;
}
