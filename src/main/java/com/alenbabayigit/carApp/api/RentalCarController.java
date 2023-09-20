package com.alenbabayigit.carApp.api;

import com.alenbabayigit.carApp.rental.RentalCarService;
import com.alenbabayigit.carApp.rental.model.request.CreateRentRequest;
import com.alenbabayigit.carApp.rental.model.request.UpdateRentRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rentalcars")
public class RentalCarController {

    private final RentalCarService rentalCarService;

    public RentalCarController(RentalCarService rentalCarService) {
        this.rentalCarService = rentalCarService;
    }

    public ResponseEntity<?> rent(@RequestBody CreateRentRequest createRentRequest) {
        return rentalCarService.rent(createRentRequest);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return rentalCarService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return rentalCarService.getById(id);
    }

    @GetMapping("getrentalsbycustomer/{customerId}")
    public ResponseEntity<?> getRentalsByCustomer(@PathVariable Integer customerId) {
        return rentalCarService.getRentalsByCustomer(customerId);
    }

    @GetMapping("/getrentalsofcar/{carId}")
    public ResponseEntity<?> getRentalsOfCar(@PathVariable Integer carId) {
        return rentalCarService.getRentalsOfCar(carId);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody UpdateRentRequest updateRentRequest) {
        return rentalCarService.update(id, updateRentRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return rentalCarService.delete(id);
    }

}
