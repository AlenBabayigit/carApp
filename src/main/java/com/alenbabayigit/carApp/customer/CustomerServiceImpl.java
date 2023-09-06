package com.alenbabayigit.carApp.customer;

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
    public Customer create(Customer customer) {
        checkCustomerAlreadyExists(customer.getEmail(), customer.getPhoneNumber());
        return customerRepository.save(customer);
    }

    public void checkCustomerAlreadyExists(String email, String phoneNumber) {
        boolean isCustomerExists = customerRepository.existsCustomerByEmailIgnoreCaseOrPhoneNumber(email, phoneNumber);
        if (isCustomerExists) {
            throw new BusinessException("Customer already exists with the following email & phone number: " + email + ", " + phoneNumber);
        }
    }

    @Override
    public CustomerGetByIdResponse getById(Integer id) {
        Customer customer = getCustomerById(id);
        return new CustomerGetByIdResponse(customer.getEmail(), customer.getPassword(), customer.getPhoneNumber());
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<CustomerGetAllResponse> list = customerRepository.findAll().stream()
                .map(customer -> new CustomerGetAllResponse(customer.getId(),
                        customer.getEmail(), customer.getPassword(), customer.getPhoneNumber())).toList();
        return ResponseBuilder.success("Data listed successfully", list);
    }

    @Override
    public Customer update(Integer id, UpdateCustomerRequest updateCustomerRequest) {
        checkCustomerAlreadyExists(updateCustomerRequest.email(), updateCustomerRequest.phoneNumber());
        Customer customer = getCustomerById(id);
        customer.setEmail(updateCustomerRequest.email());
        customer.setPassword(updateCustomerRequest.password());
        customer.setPhoneNumber(updateCustomerRequest.phoneNumber());
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElseThrow(() -> new BusinessException("There is no customer with following id: " + id));
    }

    @Override
    public void delete(Integer id) {
        getCustomerById(id);
        customerRepository.deleteById(id);
    }
}
