package com.alenbabayigit.carApp.individualcustomer;

import com.alenbabayigit.carApp.individualcustomer.model.request.CreateIndividualCustomerRequest;
import com.alenbabayigit.carApp.individualcustomer.model.request.UpdateIndividualCustomerRequest;
import com.alenbabayigit.carApp.individualcustomer.model.response.IndividualCustomerGetByIdResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class IndividualCustomerServiceImpl implements IndividualCustomerService {
    @Override
    public IndividualCustomer create(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        return null;
    }

    @Override
    public IndividualCustomerGetByIdResponse getById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> getAll() {
        return null;
    }

    @Override
    public IndividualCustomer update(Integer id, UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
        return null;
    }

    @Override
    public IndividualCustomer getUserById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
