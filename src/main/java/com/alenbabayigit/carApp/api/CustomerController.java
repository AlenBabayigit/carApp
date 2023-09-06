package com.alenbabayigit.carApp.api;

import com.alenbabayigit.carApp.customer.Customer;
import com.alenbabayigit.carApp.customer.CustomerServiceImpl;
import com.alenbabayigit.carApp.customer.model.request.UpdateCustomerRequest;
import com.alenbabayigit.carApp.customer.model.response.CustomerGetByIdResponse;
import com.alenbabayigit.carApp.user.User;
import com.alenbabayigit.carApp.user.model.request.UpdateUserRequest;
import com.alenbabayigit.carApp.user.model.response.UserGetByIdResponse;
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
    public Customer create(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public CustomerGetByIdResponse getById(@PathVariable Integer id) {
        return customerService.getById(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Integer id, @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        return customerService.update(id, updateCustomerRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        customerService.delete(id);
    }



}
