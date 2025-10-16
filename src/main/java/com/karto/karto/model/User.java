package com.karto.karto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.Data;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_email", length = 256, nullable = false)
    String userEmail;

    @Column(name = "username", length = 31, nullable = false)
    String username;

    @Column(name = "hashed_password", length = 127, nullable = false)
    String hashedPassword;

    @Column(name = "created_datetime", length = 30, nullable = false)
    @UpdateTimestamp(source = SourceType.DB)
    Instant createdDatetime;
    // default should be current timestamp
}
