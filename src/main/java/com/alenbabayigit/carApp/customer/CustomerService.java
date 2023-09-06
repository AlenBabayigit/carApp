package com.alenbabayigit.carApp.customer;

import com.alenbabayigit.carApp.customer.model.request.CreateCustomerRequest;
import com.alenbabayigit.carApp.customer.model.request.UpdateCustomerRequest;
import com.alenbabayigit.carApp.customer.model.response.CustomerGetByIdResponse;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
  Customer create(CreateCustomerRequest createCustomerRequest);

  CustomerGetByIdResponse getById(Integer id);

  ResponseEntity<?> getAll();

  Customer update(Integer id, UpdateCustomerRequest updateCustomerRequest);

  Customer getCustomerById(Integer id);

  void delete(Integer id);
}
