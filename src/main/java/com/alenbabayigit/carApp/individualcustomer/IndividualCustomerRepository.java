package com.alenbabayigit.carApp.individualcustomer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, Integer> {
    boolean existsIndividualCustomerByEmailIgnoreCase(String email);
    boolean existsIndividualCustomerByPhoneNumber(String phoneNumber);
    boolean existsIndividualCustomerByNationalId(String nationalId);
}
