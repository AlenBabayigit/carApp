package com.alenbabayigit.carApp.car.model.request;

public record CreateCarRequest(Double dailyPrice, Integer modelYear,
                               String description, Integer brandId, Integer colorId) {}
