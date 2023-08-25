package com.alenbabayigit.carApp.car;

import java.util.List;
import java.util.Optional;

import com.alenbabayigit.carApp.brand.BrandServiceImpl;
import com.alenbabayigit.carApp.car.model.request.CreateCarRequest;
import com.alenbabayigit.carApp.car.model.request.UpdateCarRequest;
import com.alenbabayigit.carApp.color.ColorServiceImpl;
import com.alenbabayigit.carApp.exception.BusinessException;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final BrandServiceImpl brandService;
    private final ColorServiceImpl colorService;
    
    public CarServiceImpl(CarRepository carRepository, BrandServiceImpl brandService, ColorServiceImpl colorService) {
        this.carRepository = carRepository;
        this.brandService = brandService;
        this.colorService = colorService;
    }

    @Override
    public Car create(CreateCarRequest createCarRequest) {
        Car car = new Car();
        car.setDailyPrice(createCarRequest.dailyPrice());
        car.setModelYear(createCarRequest.modelYear());
        car.setDescription(createCarRequest.description());
        car.setBrand(brandService.getBrandById(createCarRequest.brandId()));
        car.setColor(colorService.getColorById(createCarRequest.colorId()));
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
    public Car update(Integer id, UpdateCarRequest updateCarRequest) {
        Car car = getCarById(id);

        car.setDailyPrice(updateCarRequest.dailyPrice());
        car.setModelYear(updateCarRequest.modelYear());
        car.setDescription(updateCarRequest.description());
        car.setBrand(brandService.getBrandById(updateCarRequest.brandId()));
        car.setColor(colorService.getColorById(updateCarRequest.colorId()));

        return carRepository.save(car);

    }

    private Car getCarById(Integer id) {
        return carRepository.findById(id).orElseThrow(() -> new BusinessException("There is no car with following id: " + id));
  }

    @Override
    public void delete(Integer id) {
        getCarById(id);
        carRepository.deleteById(id);
    }

}
