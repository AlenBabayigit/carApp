package com.alenbabayigit.carApp.api;

import com.alenbabayigit.carApp.car.Car;
import com.alenbabayigit.carApp.car.CarServiceImpl;
import com.alenbabayigit.carApp.car.model.request.CreateCarRequest;
import com.alenbabayigit.carApp.car.model.request.UpdateCarRequest;
import com.alenbabayigit.carApp.car.model.response.CarGetByIdResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarServiceImpl carService;

    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @PostMapping
    public Car create(@RequestBody CreateCarRequest createCarRequest) {
        return carService.create(createCarRequest);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public CarGetByIdResponse getById(@PathVariable Integer id) {
        return carService.getById(id);
    }

    @PutMapping("/{id}")
    public Car update(@PathVariable Integer  id, @RequestBody UpdateCarRequest updateCarRequest) {
        return carService.update(id, updateCarRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        carService.delete(id);
    }
}
