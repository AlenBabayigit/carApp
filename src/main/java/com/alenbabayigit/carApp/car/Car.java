package com.alenbabayigit.carApp.car;

import com.alenbabayigit.carApp.brand.Brand;
import com.alenbabayigit.carApp.color.Color;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cars")
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Double dailyPrice;

    @Column
    private Integer modelYear;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;



}
