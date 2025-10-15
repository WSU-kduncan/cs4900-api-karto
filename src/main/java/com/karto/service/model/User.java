package com.karto.service.model;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    String hashedPassword;

    @Column(name = "created_datetime", nullable = false)
    @CreationTimestamp(source = SourceType.DB)
    Instant createdDatetime;
}