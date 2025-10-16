package com.karto.karto.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "car_image")
public class CarImage {

    @Id
    @JoinColumn(name = "car_vin")
    @OneToOne
    Car car;

    @Lob
    @Column(name = "car_image", columnDefinition = "MEDIUMBLOB", nullable = false)
    byte[] carImage;
}
