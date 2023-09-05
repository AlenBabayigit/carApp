package com.alenbabayigit.carApp.corporatecustomer.model.response;

public record CorporateCustomerGetByIdResponse(
    String email, String password, String phoneNumber, String companyName, String taxNumber) {}
