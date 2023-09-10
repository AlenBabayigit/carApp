package com.alenbabayigit.carApp.rental;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalCarRepository extends JpaRepository<RentalCar, Integer> {

    List<RentalCar> findRentalCarsByCustomer_Id(Integer customerId);

    List<RentalCar> findRentalCarsByCar_Id(Integer carId);
}
