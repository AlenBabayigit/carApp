package com.alenbabayigit.carApp.car;


import com.alenbabayigit.carApp.car.model.request.CreateCarRequest;
import com.alenbabayigit.carApp.car.model.request.UpdateCarRequest;
import com.alenbabayigit.carApp.car.model.response.CarGetByIdResponse;
import org.springframework.http.ResponseEntity;

public interface CarService {
    Car create(CreateCarRequest createCarRequest);

    CarGetByIdResponse getById(Integer id);

    ResponseEntity<?> getAll();

    Car update(Integer id, UpdateCarRequest updateCarRequest);

    Car getCarById(Integer id);

    void delete(Integer id);
}
