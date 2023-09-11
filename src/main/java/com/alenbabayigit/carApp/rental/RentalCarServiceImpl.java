package com.alenbabayigit.carApp.rental;

import com.alenbabayigit.carApp.brand.model.response.BrandGetByIdResponse;
import com.alenbabayigit.carApp.car.CarServiceImpl;
import com.alenbabayigit.carApp.car.model.response.CarGetByIdResponse;
import com.alenbabayigit.carApp.color.model.response.ColorGetByIdResponse;
import com.alenbabayigit.carApp.customer.CustomerServiceImpl;
import com.alenbabayigit.carApp.customer.model.response.CustomerGetByIdResponse;
import com.alenbabayigit.carApp.exception.BusinessException;
import com.alenbabayigit.carApp.rental.model.request.CreateRentRequest;
import com.alenbabayigit.carApp.rental.model.request.UpdateRentRequest;
import com.alenbabayigit.carApp.rental.model.response.RentGetAllResponse;
import com.alenbabayigit.carApp.rental.model.response.RentGetByIdResponse;
import com.alenbabayigit.carApp.util.ResponseBuilder;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RentalCarServiceImpl implements RentalCarService {

    private final RentalCarRepository rentalCarRepository;
    private final CarServiceImpl carService;
    private final CustomerServiceImpl customerService;

    public RentalCarServiceImpl(RentalCarRepository rentalCarRepository, CarServiceImpl carService, CustomerServiceImpl customerService) {
        this.rentalCarRepository = rentalCarRepository;
        this.carService = carService;
        this.customerService = customerService;
    }

    @Override
    public ResponseEntity<?> rent(CreateRentRequest createRentRequest) {
        LocalDateTime rentDate = createRentRequest.rentDate();
        LocalDateTime returnDate = createRentRequest.returnDate();
        // Constraints:
        // Return date should be later than rent date
        checkRentDateReturnDateValidation(rentDate, returnDate);
        // Car must not have been rented after rent date
        checkCarIsAlreadyRented(createRentRequest.rentDate(), createRentRequest.carId());
        // Create rental
        RentalCar rentalCar = createRentalCarFromCreateRentRequest(createRentRequest);
        return ResponseBuilder.success("Car rented successfully.", rentalCarRepository.save(rentalCar));
    }

    private void checkRentDateReturnDateValidation(LocalDateTime rentDate, LocalDateTime returnDate) {
        if (rentDate.isAfter(returnDate)) {
            throw new BusinessException("Return date should be later than rent date.");
        }
    }

    private void checkCarIsAlreadyRented(LocalDateTime rentDate, Integer carId) {
        // Desired rent date should be after the return date of the same car's rentals
        List<LocalDateTime> returnDates = rentalCarRepository.findRentalCarsByCar_Id(carId).stream().map(RentalCar::getReturnDate).toList();
        for (LocalDateTime returnDate: returnDates) {
            if (returnDate.isAfter(rentDate)) {
                throw new BusinessException("Car is already rented.");
            }
        }
    }

    private RentalCar createRentalCarFromCreateRentRequest(CreateRentRequest createRentRequest) {
        RentalCar rentalCar = new RentalCar();
        rentalCar.setCar(carService.getCarById(createRentRequest.carId()));
        rentalCar.setCustomer(customerService.getCustomerById(createRentRequest.customerId()));
        rentalCar.setRentDate(createRentRequest.rentDate());
        rentalCar.setReturnDate(createRentRequest.returnDate());
        return rentalCar;
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        RentalCar rentalCar = getRentalCarById(id);
        return ResponseBuilder.success("Data listed successfully.", createRentGetByIdResponseFromRentalCar(rentalCar));
    }

    private static RentGetByIdResponse createRentGetByIdResponseFromRentalCar(RentalCar rentalCar) {
        return new RentGetByIdResponse(
            new CustomerGetByIdResponse(
                rentalCar.getCustomer().getEmail(),
                rentalCar.getCustomer().getPassword(),
                rentalCar.getCustomer().getPhoneNumber()),
            new CarGetByIdResponse(
                rentalCar.getCar().getDailyPrice(),
                rentalCar.getCar().getModelYear(),
                rentalCar.getCar().getPlate(),
                new BrandGetByIdResponse(rentalCar.getCar().getBrand().getName()),
                new ColorGetByIdResponse(rentalCar.getCar().getColor().getName())),
            rentalCar.getRentDate(),
            rentalCar.getReturnDate());
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<RentGetAllResponse> list = rentalCarRepository.findAll().stream().map(rentalCar -> new RentGetAllResponse(rentalCar.getId(),
                new CustomerGetByIdResponse(rentalCar.getCustomer().getEmail(), rentalCar.getCustomer().getPassword(), rentalCar.getCustomer().getPhoneNumber()),
                new CarGetByIdResponse(rentalCar.getCar().getDailyPrice(), rentalCar.getCar().getModelYear(), rentalCar.getCar().getPlate(), new BrandGetByIdResponse(rentalCar.getCar().getBrand().getName()), new ColorGetByIdResponse(rentalCar.getCar().getColor().getName())), rentalCar.getRentDate(), rentalCar.getReturnDate())).toList();
        return ResponseBuilder.success("Data listed successfully.", list);
    }

    @Override
    public ResponseEntity<?> getRentalsByCustomer(Integer customerId) {
        List<RentalCar> list = rentalCarRepository.findRentalCarsByCustomer_Id(customerId);
        return ResponseBuilder.success("Rentals of customer with the following email: " + customerService.getCustomerById(customerId).getEmail(), list);
    }

    @Override
    public ResponseEntity<?> getRentalsOfCar(Integer carId) {
        List<String> list = rentalCarRepository.findRentalCarsByCar_Id(carId).stream().map(rentalCar -> rentalCar.getCustomer().getEmail()).toList();
        return ResponseBuilder.success("Rentals of car with the following plate: " + carService.getCarById(carId).getPlate(), list);
    }

    @Override
    public ResponseEntity<?> update(Integer id, UpdateRentRequest updateRentRequest) {
        // Constraints
        checkRentDateReturnDateValidation(updateRentRequest.rentDate(), updateRentRequest.returnDate());
        checkCarIsAlreadyRented(updateRentRequest.rentDate(), updateRentRequest.carId());

        RentalCar rentalCar = getRentalCarById(id);
        updateRentalCarFields(updateRentRequest, rentalCar);
        return ResponseBuilder.success("Rent updated successfully", rentalCarRepository.save(rentalCar));
    }

    private void updateRentalCarFields(UpdateRentRequest updateRentRequest, RentalCar rentalCar) {
        rentalCar.setCar(carService.getCarById(updateRentRequest.carId()));
        rentalCar.setCustomer(customerService.getCustomerById(updateRentRequest.customerId()));
        rentalCar.setRentDate(updateRentRequest.rentDate());
        rentalCar.setReturnDate(updateRentRequest.returnDate());
    }

    @Override
    public RentalCar getRentalCarById(Integer id) {
        return rentalCarRepository.findById(id).orElseThrow(() -> new BusinessException("There is no rental with following id: " + id));
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        getRentalCarById(id);
        rentalCarRepository.deleteById(id);
        return ResponseBuilder.success("Rental car data deleted successfully.", null);
    }
}
