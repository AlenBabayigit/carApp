package com.alenbabayigit.carApp.individualcustomer;

import com.alenbabayigit.carApp.individualcustomer.model.request.CreateIndividualCustomerRequest;
import com.alenbabayigit.carApp.individualcustomer.model.request.UpdateIndividualCustomerRequest;
import com.alenbabayigit.carApp.individualcustomer.model.response.IndividualCustomerGetByIdResponse;
import org.springframework.http.ResponseEntity;

public interface IndividualCustomerService {
    ResponseEntity<?> create(CreateIndividualCustomerRequest createIndividualCustomerRequest);

    ResponseEntity<?> getById(Integer id);

    ResponseEntity<?> getAll();

    IndividualCustomer update(Integer id, UpdateIndividualCustomerRequest updateIndividualCustomerRequest);

    IndividualCustomer getIndividualCustomerById(Integer id);

    ResponseEntity<?> delete(Integer id);
}
