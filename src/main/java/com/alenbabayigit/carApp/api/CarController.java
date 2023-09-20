package com.alenbabayigit.carApp.api;

import com.alenbabayigit.carApp.car.CarService;
import com.alenbabayigit.carApp.car.model.request.CreateCarRequest;
import com.alenbabayigit.carApp.car.model.request.UpdateCarRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateCarRequest createCarRequest) {
        return carService.create(createCarRequest);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
    return carService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return carService.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody UpdateCarRequest updateCarRequest) {
        return carService.update(id, updateCarRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return carService.delete(id);
    }
}
