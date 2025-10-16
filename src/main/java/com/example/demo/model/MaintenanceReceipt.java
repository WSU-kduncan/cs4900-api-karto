package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

public class MaintenanceReceipt {

  @Id
  @JoinColumn(name = "maintenance_receipt", nullable = false)
  Maintenance maintenance;

  @Column(name = "receipt_name")
  byte[] receipt;
}
