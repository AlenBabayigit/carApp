package com.alenbabayigit.carApp.rental.model.request;

import java.time.LocalDateTime;

public record UpdateRentRequest(Integer customerId, Integer carId, LocalDateTime rentDate, LocalDateTime returnDate) {}
