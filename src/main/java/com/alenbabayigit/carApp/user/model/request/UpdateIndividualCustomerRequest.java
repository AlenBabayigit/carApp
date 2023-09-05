package com.alenbabayigit.carApp.user.model.request;

public record UpdateIndividualCustomerRequest(String email, String password, String phoneNumber,
                                              String name, String lastname, String nationalId) {}
