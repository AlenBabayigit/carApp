package com.alenbabayigit.carApp.individualcustomer;

import com.alenbabayigit.carApp.individualcustomer.model.request.CreateIndividualCustomerRequest;
import com.alenbabayigit.carApp.individualcustomer.model.request.UpdateIndividualCustomerRequest;
import com.alenbabayigit.carApp.individualcustomer.model.response.IndividualCustomerGetByIdResponse;
import org.springframework.http.ResponseEntity;

public interface IndividualCustomerService {
    IndividualCustomer create(CreateIndividualCustomerRequest createIndividualCustomerRequest);

    IndividualCustomerGetByIdResponse getById(Integer id);

    ResponseEntity<?> getAll();

    IndividualCustomer update(Integer id, UpdateIndividualCustomerRequest updateIndividualCustomerRequest);

    IndividualCustomer getUserById(Integer id);

    void delete(Integer id);
}
