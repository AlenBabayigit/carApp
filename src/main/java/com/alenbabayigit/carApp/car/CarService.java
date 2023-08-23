package com.alenbabayigit.carApp.car;


import com.alenbabayigit.carApp.car.model.request.CreateCarRequest;
import com.alenbabayigit.carApp.car.model.request.UpdateCarRequest;

import java.util.List;

public interface CarService {
    Car create(CreateCarRequest createCarRequest);
    Car getById(Integer id);
    List<Car> getAll();
    Car update(Integer id, UpdateCarRequest updateCarRequest);
    void delete(Integer id);
}
