package com.alenbabayigit.carApp.brand;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    // Create Brand
    public Brand create(Brand brand) {
        return brandRepository.save(brand);
    }

    // Get Brand by ID
    public Brand getById(String brandId) {
        Optional<Brand> optionalBrand = brandRepository.findById(brandId);
        return optionalBrand.isPresent() ? optionalBrand.get() : null;
    }

    // Get all Brands
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    // Update Brand
    public Brand update(String brandId, Brand updatedBrand) {
        Brand brand = getById(brandId);
        if (brand != null) {
            brand.setId(updatedBrand.getId());
            brand.setName(updatedBrand.getName());
            return brandRepository.save(brand);
        }
        return null;
    }

    // Delete Brand by ID
    public void delete(String brandId) {
        brandRepository.deleteById(brandId);
    }


}
