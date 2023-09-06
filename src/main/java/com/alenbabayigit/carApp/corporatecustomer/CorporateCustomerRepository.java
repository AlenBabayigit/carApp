package com.alenbabayigit.carApp.corporatecustomer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporateCustomerRepository extends JpaRepository<CorporateCustomer, Integer> {
    boolean existsCorporateCustomerByEmailIgnoreCase(String email);
    boolean existsCorporateCustomerByPhoneNumber(String phoneNumber);
    boolean existsCorporateCustomerByTaxNumber(String taxNumber);
}
