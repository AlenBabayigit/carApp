package com.alenbabayigit.carApp.api;

import com.alenbabayigit.carApp.rental.RentalCarServiceImpl;
import com.alenbabayigit.carApp.rental.model.request.CreateRentRequest;
import com.alenbabayigit.carApp.rental.model.request.UpdateRentRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rentalcars")
public class RentalCarController {

    private final RentalCarServiceImpl rentalCarService;

    public RentalCarController(RentalCarServiceImpl rentalCarService) {
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

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody UpdateRentRequest updateRentRequest) {
        return rentalCarService.update(id, updateRentRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return rentalCarService.delete(id);
    }

}
