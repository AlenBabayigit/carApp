package com.alenbabayigit.carApp.service;

import com.alenbabayigit.carApp.dao.BrandRepository;
import com.alenbabayigit.carApp.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    // Create Brand
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    // Get Brand by ID
    public Brand getBrandByID(String brandID) {
        Optional<Brand> optionalBrand = brandRepository.findById(brandID);
        return optionalBrand.isPresent() ? optionalBrand.get() : null;
    }

    // Get all Brands
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    // Update Brand
    public Brand updateBrand(String brandID, Brand updatedBrand) {
        Brand brand = getBrandByID(brandID);
        if (brand != null) {
            brand.setId(updatedBrand.getId());
            brand.setName(updatedBrand.getName());
            return brandRepository.save(brand);
        }
        return null;
    }

    // Delete Brand by ID
    public void deleteBrandByID(String brandID) {
        brandRepository.deleteById(brandID);
    }

    // Delete All Brands
    public void deleteAllBrands() {
        brandRepository.deleteAll();
    }
}
