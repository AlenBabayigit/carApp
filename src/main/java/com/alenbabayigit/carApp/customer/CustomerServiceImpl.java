package com.alenbabayigit.carApp.customer;

import com.alenbabayigit.carApp.customer.model.request.UpdateCustomerRequest;
import com.alenbabayigit.carApp.customer.model.response.CustomerGetByIdResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public Customer create(Customer customer) {
        return null;
    }

    @Override
    public CustomerGetByIdResponse getById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> getAll() {
        return null;
    }

    @Override
    public Customer update(Integer id, UpdateCustomerRequest updateCustomerRequest) {
        return null;
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
