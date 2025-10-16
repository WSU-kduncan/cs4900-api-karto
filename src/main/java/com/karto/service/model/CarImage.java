package com.karto.service.model;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "car_image")
public class CarImage {

    @Id
    @JoinColumn(name = "car_vin", nullable = false)
    @OneToOne
    Car carVin;

    @Column(name = "car_image", columnDefinition = "MEDIUMBLOB", nullable = false)
    Blob image;

}