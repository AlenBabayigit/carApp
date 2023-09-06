package com.alenbabayigit.carApp.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsCustomerByEmailIgnoreCaseAndPhoneNumber(String email, String phoneNumber);
}
