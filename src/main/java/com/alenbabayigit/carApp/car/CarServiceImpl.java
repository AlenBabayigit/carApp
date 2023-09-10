package com.alenbabayigit.carApp.car;

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
import java.util.List;
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
    public ResponseEntity<?> create(CreateCarRequest createCarRequest) {
        checkCarIsAlreadyExists(createCarRequest.plate());
        Car car = createCarFromRequest(createCarRequest);
        return ResponseBuilder.success("Car created successfully.", carRepository.save(car));
    }

    private void checkCarIsAlreadyExists(String plate) {
        boolean isCarExists = carRepository.existsCarByPlateIgnoreCase(plate);
        if (isCarExists) {
            throw new BusinessException("Car already exists: " + plate);
        }
    }

    private Car createCarFromRequest(CreateCarRequest createCarRequest) {
        Car car = new Car();
        car.setDailyPrice(createCarRequest.dailyPrice());
        car.setModelYear(createCarRequest.modelYear());
        car.setPlate(createCarRequest.plate());
        car.setBrand(brandService.getBrandById(createCarRequest.brandId()));
        car.setColor(colorService.getColorById(createCarRequest.colorId()));
        return car;
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        Car car = getCarById(id);
        return ResponseBuilder.success("Data listed successfully.", createCarGetByIdResponseFromCar(car));
    }

    private static CarGetByIdResponse createCarGetByIdResponseFromCar(Car car) {
        return new CarGetByIdResponse(car.getDailyPrice(), car.getModelYear(), car.getPlate(),
                new BrandGetByIdResponse(car.getBrand().getName()), new ColorGetByIdResponse(car.getColor().getName()));
    }

    @Override
    public ResponseEntity<?> getAll() {
    List<CarGetAllResponse> list =
        carRepository.findAll().stream()
            .map(car -> createCarGetAllResponseFromCar(car)).toList();
        return ResponseBuilder.success("Data listed successfully.", list);
    }

    private static CarGetAllResponse createCarGetAllResponseFromCar(Car car) {
        return new CarGetAllResponse(
                car.getId(),
                car.getDailyPrice(),
                car.getModelYear(),
                car.getPlate(),
                new BrandGetByIdResponse(car.getBrand().getName()),
                new ColorGetByIdResponse(car.getColor().getName()));
    }

    @Override
    public ResponseEntity<?> update(Integer id, UpdateCarRequest updateCarRequest) {
        checkCarIsAlreadyExists(updateCarRequest.plate());
        Car car = getCarById(id);
        updateCarFields(updateCarRequest, car);
        return ResponseBuilder.success("Data updated successfully.", carRepository.save(car));
    }

    private void updateCarFields(UpdateCarRequest updateCarRequest, Car car) {
        car.setDailyPrice(updateCarRequest.dailyPrice());
        car.setModelYear(updateCarRequest.modelYear());
        car.setPlate(updateCarRequest.plate());
        car.setBrand(brandService.getBrandById(updateCarRequest.brandId()));
        car.setColor(colorService.getColorById(updateCarRequest.colorId()));
    }

    @Override
    public Car getCarById(Integer id) {
        return carRepository.findById(id).orElseThrow(() -> new BusinessException("There is no car with following id: " + id));
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        getCarById(id);
        carRepository.deleteById(id);
        return ResponseBuilder.success("Car deleted successfully.", null);
    }
}
