package com.alenbabayigit.carApp.user.model.response;

public record IndividualCustomerGetAllResponse(Integer id, String email, String password, String phoneNumber,
                                               String name, String lastname, String nationalId) {}
