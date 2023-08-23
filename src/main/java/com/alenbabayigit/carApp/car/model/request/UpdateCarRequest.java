package com.alenbabayigit.carApp.car.model.request;

public record UpdateCarRequest(Double dailyPrice, Integer modelYear,
                               String description, Integer brandId, Integer colorId) {}
