package com.alenbabayigit.carApp.customer;

import com.alenbabayigit.carApp.customer.model.request.CreateCustomerRequest;
import com.alenbabayigit.carApp.customer.model.request.UpdateCustomerRequest;
import com.alenbabayigit.carApp.customer.model.response.CustomerGetAllResponse;
import com.alenbabayigit.carApp.customer.model.response.CustomerGetByIdResponse;
import com.alenbabayigit.carApp.exception.BusinessException;
import com.alenbabayigit.carApp.util.ResponseBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseEntity<?> create(CreateCustomerRequest createCustomerRequest) {
        checkCustomerAlreadyExists(createCustomerRequest.email(), createCustomerRequest.phoneNumber());
        Customer customer = new Customer();
        customer.setEmail(createCustomerRequest.email());
        customer.setPassword(createCustomerRequest.password());
        customer.setPhoneNumber(createCustomerRequest.phoneNumber());
        return ResponseBuilder.success("Customer created successfully", customerRepository.save(customer));
    }

    public void checkCustomerAlreadyExists(String email, String phoneNumber) {
        boolean isCustomerExists = customerRepository.existsCustomerByEmailIgnoreCaseOrPhoneNumber(email, phoneNumber);
        if (isCustomerExists) {
            throw new BusinessException("Customer already exists with the following email & phone number: " + email + ", " + phoneNumber);
        }
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        Customer customer = getCustomerById(id);
        return ResponseBuilder.success("Data listed successfully.",
                new CustomerGetByIdResponse(customer.getEmail(), customer.getPassword(), customer.getPhoneNumber()));
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<CustomerGetAllResponse> list = customerRepository.findAll().stream()
                .map(customer -> new CustomerGetAllResponse(customer.getId(),
                        customer.getEmail(), customer.getPassword(), customer.getPhoneNumber())).toList();
        return ResponseBuilder.success("Data listed successfully", list);
    }

    @Override
    public ResponseEntity<?> update(Integer id, UpdateCustomerRequest updateCustomerRequest) {
        checkCustomerAlreadyExists(updateCustomerRequest.email(), updateCustomerRequest.phoneNumber());
        Customer customer = getCustomerById(id);
        customer.setEmail(updateCustomerRequest.email());
        customer.setPassword(updateCustomerRequest.password());
        customer.setPhoneNumber(updateCustomerRequest.phoneNumber());
        return ResponseBuilder.success("Customer updated successfully.", customerRepository.save(customer));
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElseThrow(() -> new BusinessException("There is no customer with following id: " + id));
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        getCustomerById(id);
        customerRepository.deleteById(id);
        return ResponseBuilder.success("Customer deleted successfully.", null);
    }
}
