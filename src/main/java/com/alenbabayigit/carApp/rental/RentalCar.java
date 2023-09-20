package com.alenbabayigit.carApp.rental;

import com.alenbabayigit.carApp.car.Car;
import com.alenbabayigit.carApp.customer.Customer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class RentalCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @OneToOne
    private Customer customer;

    @OneToOne
    private Car car;

    @Column
    private LocalDateTime rentDate;

    @Column
    private LocalDateTime returnDate;

}
