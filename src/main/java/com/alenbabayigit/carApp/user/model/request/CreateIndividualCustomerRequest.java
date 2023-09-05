package com.alenbabayigit.carApp.user.model.request;

public record CreateIndividualCustomerRequest(String email, String password, String phoneNumber,
                                              String name, String lastname, String nationalId) {}
