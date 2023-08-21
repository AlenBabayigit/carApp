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

    @Override
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car getById(Integer id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        return optionalCar.orElse(null);
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car update(Integer id, Car updatedCar) {
        Car car = getById(id);
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

    @Override
    public void delete(Integer id) {
        carRepository.deleteById(id);
    }

}
