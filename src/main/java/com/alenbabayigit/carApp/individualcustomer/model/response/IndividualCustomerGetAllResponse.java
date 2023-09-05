package com.alenbabayigit.carApp.individualcustomer.model.response;

public record IndividualCustomerGetAllResponse(
    Integer id,
    String email,
    String password,
    String phoneNumber,
    String name,
    String lastname,
    String nationalId) {}
