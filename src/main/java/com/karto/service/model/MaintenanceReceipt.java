package com.karto.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "maintenance_receipt")
@Entity
@Data
public class MaintenanceReceipt {
    @Id
    Integer maintenance_id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "maintenance_id", nullable = false)
    Maintenance maintenance;

    @Column(name = "receipt_image", columnDefinition = "MEDIUMBLOB", nullable = false)
    byte[] receipt;
}
