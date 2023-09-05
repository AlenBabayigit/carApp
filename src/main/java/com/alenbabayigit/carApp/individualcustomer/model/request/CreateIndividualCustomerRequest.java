package com.alenbabayigit.carApp.individualcustomer.model.request;

public record CreateIndividualCustomerRequest(String email, String password, String phoneNumber,
                                              String name, String lastname, String nationalId) {}
