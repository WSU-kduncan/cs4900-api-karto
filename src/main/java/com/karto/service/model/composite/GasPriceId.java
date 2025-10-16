package com.karto.service.model.composite;

import java.io.Serializable;

import com.karto.service.model.GasStation;
import com.karto.service.model.GasType;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Embeddable
public class GasPriceId implements Serializable {

    @JoinColumn(name = "station_id", nullable = false)
    @ManyToOne
    GasStation gasStation;

    @JoinColumn(name = "gas_type_id", nullable = false)
    @ManyToOne
    GasType gasType;
}