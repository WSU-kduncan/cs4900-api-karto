package com.karto.service.model.composite;

import com.karto.service.model.GasStation;
import com.karto.service.model.GasType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Embeddable
public class GasPriceId {
  @JoinColumn(name = "station_id", nullable = false)
  @ManyToOne
  GasStation station;

  @JoinColumn(name = "gas_type_id", nullable = false)
  @ManyToOne
  GasType gasType;
}
