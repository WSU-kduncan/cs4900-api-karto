package com.karto.karto.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "gas_type")
public class GasType {

    @Id
    @Column(name = "gas_type_id", columnDefinition = "SMALLINT UNSIGNED", nullable = false)
    Integer gasTypeId;

    @Column(name = "name", length = 15, nullable = false)
    String name;
}
