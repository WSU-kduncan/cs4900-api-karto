package com.karto.service.model.composite;

import java.io.Serializable;

import com.karto.service.model.GasStation;
import com.karto.service.model.User;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
public class TrustedGasStationCK implements Serializable {

    @JoinColumn(name = "user_email", nullable = false, referencedColumnName = "user_email")
    @ManyToOne
    User user;

    @JoinColumn(name = "station_id", nullable = false, referencedColumnName = "station_id")
    @ManyToOne
    GasStation gasStation;

}
