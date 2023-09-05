package com.alenbabayigit.carApp.user.model.response;

public record CorporateCustomerGetByIdResponse(String email, String password, String phoneNumber,
                                               String companyName, String taxNumber) {}
