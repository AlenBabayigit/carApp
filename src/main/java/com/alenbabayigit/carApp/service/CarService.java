package com.alenbabayigit.carApp.service;

import com.alenbabayigit.carApp.entity.Car;

import java.util.List;

public interface CarService {
    Car createCar(Car car);
    Car getCarByID(String carID);
    List<Car> getAllCars();
    Car updateCar(String carID, Car updatedCar);
    void deleteCarByID(String carID);
    void deleteAllCars();
}
