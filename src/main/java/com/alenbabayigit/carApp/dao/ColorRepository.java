package com.alenbabayigit.carApp.dao;

import com.alenbabayigit.carApp.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, String> {
}
