package com.alenbabayigit.carApp.api;

import com.alenbabayigit.carApp.customer.CustomerService;
import com.alenbabayigit.carApp.customer.model.request.CreateCustomerRequest;
import com.alenbabayigit.carApp.customer.model.request.UpdateCustomerRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
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
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return customerService.delete(id);
    }



}
