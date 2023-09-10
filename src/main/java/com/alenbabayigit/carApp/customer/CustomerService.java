package com.alenbabayigit.carApp.customer;

import com.alenbabayigit.carApp.customer.model.request.CreateCustomerRequest;
import com.alenbabayigit.carApp.customer.model.request.UpdateCustomerRequest;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
  ResponseEntity<?> create(CreateCustomerRequest createCustomerRequest);

  ResponseEntity<?> getById(Integer id);

  ResponseEntity<?> getAll();

  ResponseEntity<?> update(Integer id, UpdateCustomerRequest updateCustomerRequest);

  Customer getCustomerById(Integer id);

  ResponseEntity<?> delete(Integer id);
}
