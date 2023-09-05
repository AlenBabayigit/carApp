package com.alenbabayigit.carApp.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    boolean existsCarByPlateIgnoreCase(String plate);
}
