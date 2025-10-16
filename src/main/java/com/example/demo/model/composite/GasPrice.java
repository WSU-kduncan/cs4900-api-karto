package com.example.demo.model.composite;

import com.example.demo.model.GasStation;
import com.example.demo.model.GasType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Embeddable
public class GasPrice {

  @JoinColumn(name = "station_id", nullable = false)
  @ManyToOne
  GasStation station;

  @JoinColumn(name = "gas_station_id", nullable = false)
  @ManyToOne
  GasType gasType;
}
