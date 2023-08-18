package com.alenbabayigit.carApp.dao;

import com.alenbabayigit.carApp.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, String> {
}
