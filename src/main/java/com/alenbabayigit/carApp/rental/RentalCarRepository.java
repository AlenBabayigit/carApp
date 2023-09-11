package com.alenbabayigit.carApp.rental;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalCarRepository extends JpaRepository<RentalCar, Integer> {

    List<RentalCar> findRentalCarsByCustomer_Id(Integer customerId);

    List<RentalCar> findRentalCarsByCar_Id(Integer carId);
}
