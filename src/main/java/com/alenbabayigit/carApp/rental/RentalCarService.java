package com.alenbabayigit.carApp.rental;

import com.alenbabayigit.carApp.rental.model.request.CreateRentRequest;
import com.alenbabayigit.carApp.rental.model.request.UpdateRentRequest;
import org.springframework.http.ResponseEntity;

public interface RentalCarService {

    ResponseEntity<?> rent(CreateRentRequest createRentRequest);

    ResponseEntity<?> getById(Integer id);

    ResponseEntity<?> getAll();

    ResponseEntity<?> getRentalsByCustomer(Integer customerId);

    ResponseEntity<?> getRentalsOfCar(Integer carId);

    ResponseEntity<?> update(Integer id, UpdateRentRequest updateRentRequest);

    ResponseEntity<?> delete(Integer id);
}
