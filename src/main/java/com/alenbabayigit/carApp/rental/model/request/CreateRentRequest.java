package com.alenbabayigit.carApp.rental.model.request;

import java.time.LocalDateTime;

public record CreateRentRequest(Integer customerId, Integer carId, LocalDateTime rentDate, LocalDateTime returnDate) {}
