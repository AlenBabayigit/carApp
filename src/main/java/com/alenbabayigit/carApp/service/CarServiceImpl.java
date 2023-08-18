package com.alenbabayigit.carApp.service;

import com.alenbabayigit.carApp.dao.CarRepository;
import com.alenbabayigit.carApp.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // Create Car
    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    // Get Car by ID
    @Override
    public Car getCarByID(String carID) {
        Optional<Car> optionalCar = carRepository.findById(carID);
        return optionalCar.isPresent() ? optionalCar.get() : null;
    }

    // Get all Cars
    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    // Update Car
    @Override
    public Car updateCar(String carID, Car updatedCar) {
        Car car = getCarByID(carID);
        if (car != null) {
            car.setId(updatedCar.getId());
            car.setDailyPrice(updatedCar.getDailyPrice());
            car.setModelYear(updatedCar.getModelYear());
            car.setDescription(updatedCar.getDescription());
            car.setBrand(updatedCar.getBrand());
            car.setColor(updatedCar.getColor());
            return carRepository.save(car);
        }
        return null;
    }

    // Delete Car by ID
    @Override
    public void deleteCarByID(String carID) {
        carRepository.deleteById(carID);
    }

    // Delete all Cars
    @Override
    public void deleteAllCars() {
        carRepository.deleteAll();
    }
}
