package com.alenbabayigit.carApp.corporatecustomer.model.request;

public record UpdateCorporateCustomerRequest(
    String email, String password, String phoneNumber, String companyName, String taxNumber) {}
