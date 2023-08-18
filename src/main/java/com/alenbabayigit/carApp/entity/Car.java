package com.alenbabayigit.carApp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "`CAR`", schema = "public", catalog = "car_app")
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "\"Car_daily_price\"")
    private int dailyPrice;

    @Column(name = "\"Car_model_year\"")
    private int modelYear;

    @Column(name = "\"Car_description\"")
    private String description;

    @ManyToOne
    @JoinColumn(name = "\"Brand_id\"", nullable = false)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "\"Color_id\"", nullable = false)
    private Color color;



}
