package com.alenbabayigit.carApp.individualcustomer.model.response;

public record IndividualCustomerGetByIdResponse(String email, String password, String phoneNumber,
                                                String name, String lastname, String nationalId) {}
