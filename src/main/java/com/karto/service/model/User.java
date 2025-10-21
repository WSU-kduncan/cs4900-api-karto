package com.karto.service.model;

import java.time.Instant;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_email", length = 255, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String email;
    
    @Column(name = "username", length = 31, nullable = false)
    String username;

    @Column(name = "hashed_password", length = 127, nullable = false)
    String password;

    @Column(name = "created_datetime")
    @CreationTimestamp(source = SourceType.DB)
    Instant createdAt;

    @JoinTable(
        name = "trusted_gas_station",
        joinColumns = @JoinColumn(name = "user_email"),
        inverseJoinColumns = @JoinColumn(name = "station_id")
    )
    @ManyToMany
    List<GasStation> trustedGasStations;
}