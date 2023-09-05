package com.alenbabayigit.carApp.individualcustomer;

import com.alenbabayigit.carApp.customer.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class IndividualCustomer extends Customer {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false, unique = true)
    private String nationalId;
}
