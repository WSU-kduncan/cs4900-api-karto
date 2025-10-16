package com.karto.service.model;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "maintenance_receipt")
public class MaintenanceReceipt {

    @Id
    @OneToOne
    @JoinColumn(name = "maintenance_id", nullable = false)
    Maintenance maintenance;

    @Column(name = "receipt_image", columnDefinition = "MEDIUMBLOB", nullable = false)
    Blob image;

}
