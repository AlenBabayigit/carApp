package com.alenbabayigit.carApp.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class CorporateCustomer extends Customer {

    @Column
    private String companyName;

    @Column
    private String taxNumber;
}
