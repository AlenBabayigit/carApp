package com.alenbabayigit.carApp.car;


import java.util.List;

public interface CarService {
    Car create(Car car);
    Car getById(Integer id);
    List<Car> getAll();
    Car update(Integer id, Car updatedCar);
    void delete(Integer id);
}
