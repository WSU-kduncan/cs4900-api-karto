package com.karto.service.model.composite;

import com.karto.service.model.Maintenance;
import com.karto.service.model.MaintenanceTypeDescription;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Embeddable
@Data
public class MaintenanceItemDetailId {
  @JoinColumn(name = "maintenance_type_id", nullable = false)
  @ManyToOne
  MaintenanceTypeDescription maintenanceType;

  @EqualsAndHashCode.Exclude
  @JoinColumn(name = "maintenance_id", nullable = false)
  @ManyToOne
  Maintenance maintenance;
}
