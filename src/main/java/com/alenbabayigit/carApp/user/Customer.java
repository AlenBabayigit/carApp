package com.alenbabayigit.carApp.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Customer extends User {

    @Column
    private String phoneNumber;

}
