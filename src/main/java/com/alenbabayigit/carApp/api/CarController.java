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

    // Create a new Car
    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carService.createCar(car);
    }

    // Get all Cars
    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    // Get Car by ID
    @GetMapping("/{carID}")
    public Car getCarById(@PathVariable String carID) {
        return carService.getCarByID(carID);
    }

    // Update Car by ID
    @PutMapping("/{carID}")
    public Car updateCar(@PathVariable String  carID, @RequestBody Car updatedCar) {
        return carService.updateCar(carID, updatedCar);
    }

    // Delete all Cars
    @DeleteMapping
    public String deleteAllCars() {
        carService.deleteAllCars();
        return "All cars have been deleted successfully.";
    }

    // Delete Car by ID
    @DeleteMapping("/{carID}")
    public void deleteCar(@PathVariable String carID) {
        carService.deleteCarByID(carID);
    }
}
