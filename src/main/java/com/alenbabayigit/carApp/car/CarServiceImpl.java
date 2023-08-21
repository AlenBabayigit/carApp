package com.alenbabayigit.carApp.car;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // Create Car
    @Override
    public Car create(Car car) {
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
    public List<Car> getAll() {
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
    public void delete(String id) {
        carRepository.deleteById(id);
    }

    // Delete all Cars
    @Override
    public void deleteAllCars() {
        carRepository.deleteAll();
    }
}
