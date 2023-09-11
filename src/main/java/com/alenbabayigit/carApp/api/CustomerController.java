package com.alenbabayigit.carApp.api;

import com.alenbabayigit.carApp.customer.Customer;
import com.alenbabayigit.carApp.customer.CustomerServiceImpl;
import com.alenbabayigit.carApp.customer.model.request.CreateCustomerRequest;
import com.alenbabayigit.carApp.customer.model.request.UpdateCustomerRequest;
import com.alenbabayigit.carApp.customer.model.response.CustomerGetByIdResponse;
import com.alenbabayigit.carApp.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateCustomerRequest createCustomerRequest) {
        return customerService.create(createCustomerRequest);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return customerService.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        return customerService.update(id, updateCustomerRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        customerService.delete(id);
    }



}
