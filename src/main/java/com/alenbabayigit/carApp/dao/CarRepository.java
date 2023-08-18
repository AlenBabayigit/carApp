package com.alenbabayigit.carApp.dao;

import com.alenbabayigit.carApp.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, String> {
}
