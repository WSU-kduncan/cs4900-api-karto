package com.karto.karto.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "trusted_gas_station")
public class TrustedGasStation {

    @Id
    @JoinColumn(name = "user_email", nullable = false)
    @ManyToOne
    User user;

    @Id
    @JoinColumn(name = "station_id", columnDefinition = "INT UNSIGNED", nullable = false)
    @ManyToOne
    GasStation gasStation;
}
