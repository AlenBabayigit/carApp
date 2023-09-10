package com.alenbabayigit.carApp.individualcustomer;

import com.alenbabayigit.carApp.individualcustomer.model.request.CreateIndividualCustomerRequest;
import com.alenbabayigit.carApp.individualcustomer.model.request.UpdateIndividualCustomerRequest;
import org.springframework.http.ResponseEntity;

public interface IndividualCustomerService {
    ResponseEntity<?> create(CreateIndividualCustomerRequest createIndividualCustomerRequest);

    ResponseEntity<?> getById(Integer id);

    ResponseEntity<?> getAll();

    ResponseEntity<?> update(Integer id, UpdateIndividualCustomerRequest updateIndividualCustomerRequest);

    IndividualCustomer getIndividualCustomerById(Integer id);

    ResponseEntity<?> delete(Integer id);
}
