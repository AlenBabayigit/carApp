package com.alenbabayigit.carApp.car.model.response;

import com.alenbabayigit.carApp.brand.model.response.BrandGetByIdResponse;
import com.alenbabayigit.carApp.color.model.response.ColorGetByIdResponse;

public record CarGetByIdResponse(Double dailyPrice, Integer modelYear, String plate,
                                 BrandGetByIdResponse brandGetByIdResponse, ColorGetByIdResponse colorGetByIdResponse) {}
