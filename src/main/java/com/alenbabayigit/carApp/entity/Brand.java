package com.alenbabayigit.carApp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "BRAND")
@Data
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Brand_id")
    private String id;

    @Column(name = "Brand_name", nullable = false)
    private String name;

}
