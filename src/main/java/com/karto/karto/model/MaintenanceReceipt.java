package com.karto.karto.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "maintenance_receipt")
public class MaintenanceReceipt {

    @Id
    @JoinColumn(name = "maintenance_id", nullable = false, unique = true)
    @OneToOne
    Maintenance maintenance;

    @Lob
    @Column(name = "receipt_image", columnDefinition = "MEDIUMBLOB")
    byte[] receiptImage;
}
