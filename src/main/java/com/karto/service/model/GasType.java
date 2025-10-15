package com.karto.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "gas_type")
public class GasType {

    @Id
    @Column(name = "gas_type_id", columnDefinition="SMALLINT", nullable = false)
    Integer id;

    @Column(name = "name", length=15, nullable = false)
    String name;
}