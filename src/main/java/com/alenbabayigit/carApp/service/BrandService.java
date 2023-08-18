package com.alenbabayigit.carApp.service;

import com.alenbabayigit.carApp.entity.Brand;

import java.util.List;

public interface BrandService {
    Brand createBrand(Brand brand);
    Brand getBrandByID(String brandID);
    List<Brand> getAllBrands();
    Brand updateBrand(String brandID, Brand updatedBrand);
    void deleteBrandByID(String brandID);
    void deleteAllBrands();
}
