package com.alenbabayigit.carApp.user;

import com.alenbabayigit.carApp.user.model.request.UpdateCustomerRequest;
import com.alenbabayigit.carApp.user.model.response.CustomerGetByIdResponse;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    Customer create(Customer customer);

    CustomerGetByIdResponse getById(Integer id);

    ResponseEntity<?> getAll();

    Customer update(Integer id, UpdateCustomerRequest updateCustomerRequest);

    Customer getUserById(Integer id);

    void delete(Integer id);
}
