package com.example.demo.model;

import java.math.BigDecimal;
import java.time.Instant;

import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.demo.model.composite.GasPriceId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "gas_price")
public class GasPrice {
    @EmbeddedId
    GasPriceId id;

    @Column(name = "price_per_gallon", columnDefinition = "DECIMAL(7,4) UNSIGNED", nullable = false)
    BigDecimal price;

    @Column(name = "last_updated")
    @UpdateTimestamp(source = SourceType.DB)
    Instant updated;
}
