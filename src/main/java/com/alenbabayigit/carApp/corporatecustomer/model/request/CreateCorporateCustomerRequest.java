package com.alenbabayigit.carApp.corporatecustomer.model.request;

public record CreateCorporateCustomerRequest(
    String email, String password, String phoneNumber, String companyName, String taxNumber) {}
