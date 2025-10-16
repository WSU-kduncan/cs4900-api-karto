package com.karto.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

public class MaintenanceReceipt {
    @Id
    @JoinColumn(name = "maintenance_id", nullable = false)
    Maintenance maintenance;

    @Column(name = "receipt_image", columnDefinition = "MEDIUMBLOB", nullable = false)
    byte[] receipt;
}
