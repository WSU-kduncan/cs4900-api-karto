package com.karto.service.model;

import java.time.Instant;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

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
}