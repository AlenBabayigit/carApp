package com.alenbabayigit.carApp.car.model.request;

public record CreateCarRequest(Double dailyPrice, Integer modelYear,
                               String plate, Integer brandId, Integer colorId) {}
