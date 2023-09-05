package com.alenbabayigit.carApp.car.model.response;

import com.alenbabayigit.carApp.brand.model.response.BrandGetByIdResponse;
import com.alenbabayigit.carApp.color.model.response.ColorGetByIdResponse;

public record CarGetAllResponse(Integer id, Double dailyPrice, Integer modelYear, String plate,
                                BrandGetByIdResponse brand, ColorGetByIdResponse color) {}
