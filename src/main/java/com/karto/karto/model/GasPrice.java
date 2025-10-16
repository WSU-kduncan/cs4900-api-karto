package com.karto.karto.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name = "gas_price")
public class GasPrice {

    @Id
    @JoinColumn(name = "station_id", columnDefinition = "INT UNSIGNED", nullable = false)
    @ManyToOne
    GasStation gasStation;

    @Id
    @JoinColumn(name = "gas_type_id", columnDefinition = "SMALLINT UNSIGNED", nullable = false)
    @ManyToOne
    GasType gasType;

    @Column(name = "price_per_gallon", columnDefinition = "DECIMAL(7 ,4) UNSIGNED", nullable = false)
    Long pricePerGallon;

    @Column(name = "last_updated", nullable = false)
    @UpdateTimestamp(source = SourceType.DB)
    Instant lastUpdated;
    // default should be current timestamp
}
