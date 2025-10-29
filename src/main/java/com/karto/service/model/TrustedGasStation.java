package com.karto.service.model;

import com.karto.service.model.composite.TrustedGasStationId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "trusted_gas_station")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrustedGasStation {

  @EmbeddedId
  TrustedGasStationId id;

  @JoinColumn(name = "user_email", nullable = false)
  @ManyToOne
  @MapsId("userEmail")
  User user;

  @JoinColumn(name = "station_id", nullable = false)
  @ManyToOne
  @MapsId("stationId")
  GasStation gasStation;

  public TrustedGasStation(TrustedGasStationId id) {
    this.id = id;
  }
}
