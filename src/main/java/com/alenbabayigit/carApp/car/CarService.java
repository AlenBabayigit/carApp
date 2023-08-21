package com.alenbabayigit.carApp.car;


import java.util.List;

public interface CarService {
    Car create(Car car);
    Car getByID(Integer id);
    List<Car> getAll();
    Car updateCar(Integer id, Car updatedCar);
    void delete(Integer id);
}
