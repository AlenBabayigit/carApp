package com.alenbabayigit.carApp.car;

import java.util.List;
import java.util.Optional;

import com.alenbabayigit.carApp.brand.BrandServiceImpl;
import com.alenbabayigit.carApp.brand.model.response.BrandGetByIdResponse;
import com.alenbabayigit.carApp.car.model.request.CreateCarRequest;
import com.alenbabayigit.carApp.car.model.request.UpdateCarRequest;
import com.alenbabayigit.carApp.car.model.response.CarGetAllResponse;
import com.alenbabayigit.carApp.car.model.response.CarGetByIdResponse;
import com.alenbabayigit.carApp.color.ColorServiceImpl;
import com.alenbabayigit.carApp.color.model.response.ColorGetByIdResponse;
import com.alenbabayigit.carApp.exception.BusinessException;
import com.alenbabayigit.carApp.util.ResponseBuilder;
import org.springframework.http.ResponseEntity;
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
    public CarGetByIdResponse getById(Integer id) {
        Car car = getCarById(id);
        return new CarGetByIdResponse(car.getDailyPrice(), car.getModelYear(), car.getDescription(),
                new BrandGetByIdResponse(car.getBrand().getName()), new ColorGetByIdResponse(car.getColor().getName()));
    }

    @Override
    public ResponseEntity<?> getAll() {
    List<CarGetAllResponse> list =
        carRepository.findAll().stream()
            .map(
                car ->
                    new CarGetAllResponse(
                        car.getId(),
                        car.getDailyPrice(),
                        car.getModelYear(),
                        car.getDescription(),
                        car.getBrand(),
                        car.getColor())).toList();
                        //new BrandGetByIdResponse(car.getBrand().getName()),
                        //new ColorGetByIdResponse(car.getColor().getName()))).toList();
        return ResponseBuilder.success("Data listed successfully.", list);
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

    @Override
    public Car getCarById(Integer id) {
        return carRepository.findById(id).orElseThrow(() -> new BusinessException("There is no car with following id: " + id));
  }

    @Override
    public void delete(Integer id) {
        getCarById(id);
        carRepository.deleteById(id);
    }

}
