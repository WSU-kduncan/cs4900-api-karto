package com.karto.service.model;

import com.karto.service.model.composite.GasPriceId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;
import lombok.Data;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

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
