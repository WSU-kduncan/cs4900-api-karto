package com.example.demo.model.composite;

import com.example.demo.model.Maintenance;
import com.example.demo.model.MaintenanceTypeDescription;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Embeddable
@Data
public class MaintenanceItemDetailId {
    @JoinColumn(name = "maintenance_type_id", nullable = false)
    @ManyToOne
    MaintenanceTypeDescription maintenanceType;

    @JoinColumn(name = "maintenance_id", nullable = false)
    @ManyToOne
    Maintenance maintenance;
}
