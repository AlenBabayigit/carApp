package com.alenbabayigit.carApp.user.model.response;

public record CorporateCustomerGetAllResponse(Integer id, String email, String password,
                                              String phoneNumber, String companyName, String taxNumber) {}
