package com.alenbabayigit.carApp.rental.model.response;

import com.alenbabayigit.carApp.car.model.response.CarGetByIdResponse;
import com.alenbabayigit.carApp.customer.model.response.CustomerGetByIdResponse;

import java.time.LocalDateTime;

public record RentGetByIdResponse(CustomerGetByIdResponse customerGetByIdResponse,
                                  CarGetByIdResponse carGetByIdResponse, LocalDateTime rentDate, LocalDateTime returnDate) {}
