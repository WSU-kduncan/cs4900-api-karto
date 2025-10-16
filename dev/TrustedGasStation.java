package com.karto.service.model;

import com.karto.service.model.composite.TrustedGasStationCK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "trusted_gas_station")
public class TrustedGasStation {

    @EmbeddedId
    TrustedGasStationCK id;

}