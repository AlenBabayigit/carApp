package com.alenbabayigit.carApp.car;


import com.alenbabayigit.carApp.car.model.request.CreateCarRequest;
import com.alenbabayigit.carApp.car.model.request.UpdateCarRequest;
import com.alenbabayigit.carApp.car.model.response.CarGetByIdResponse;
import org.springframework.http.ResponseEntity;

public interface CarService {
    ResponseEntity<?> create(CreateCarRequest createCarRequest);

    ResponseEntity<?> getById(Integer id);

    ResponseEntity<?> getAll();

    ResponseEntity<?> update(Integer id, UpdateCarRequest updateCarRequest);

    Car getCarById(Integer id);

    ResponseEntity<?> delete(Integer id);
}
