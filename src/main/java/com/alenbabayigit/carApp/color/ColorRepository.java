package com.alenbabayigit.carApp.color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color, Integer> {
    boolean existsColorByNameIgnoreCase(String name);
}
