package com.alenbabayigit.carApp.customer.model.response;

public record CustomerGetAllResponse(
    Integer id, String email, String password, String phoneNumber) {}
