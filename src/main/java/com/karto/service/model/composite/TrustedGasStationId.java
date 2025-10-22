package com.karto.service.model.composite;

import jakarta.persistence.Column;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class TrustedGasStationId {
    @Column(name = "user_email", nullable = false)
    String userEmail;

    @Column(name = "station_id", nullable = false)
    Integer stationId;
}
