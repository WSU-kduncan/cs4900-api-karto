package com.karto.service.model;

import java.math.BigDecimal;
import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import com.karto.service.model.composite.GasPriceId;

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

    @Column(name = "price_per_gallon", columnDefinition = "DECIMAL(6, 4)", nullable = false)
    BigDecimal pricePerGallon;

    @Column(name = "last_updated", columnDefinition = "DATETIME", nullable = false)
    @CreationTimestamp(source = SourceType.DB)
    Instant lastUpdated;
}