package com.alenbabayigit.carApp.api;

import com.alenbabayigit.carApp.car.Car;
import com.alenbabayigit.carApp.car.CarServiceImpl;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarServiceImpl carService;

    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @PostMapping
    public Car create(@RequestBody Car car) {
        return carService.create(car);
    }

    @GetMapping
    public List<Car> getAll() {
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable Integer id) {
        return carService.getById(id);
    }

    @PutMapping("/{id}")
    public Car update(@PathVariable Integer  id, @RequestBody Car updatedCar) {
        return carService.update(id, updatedCar);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        carService.delete(id);
    }
}
