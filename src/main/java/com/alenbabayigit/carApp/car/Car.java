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
    private String plate;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Brand brand;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Color color;


}
