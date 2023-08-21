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

    public Brand create(Brand brand) {
        return brandRepository.save(brand);
    }

    public Brand getById(Integer id) {
        Optional<Brand> optionalBrand = brandRepository.findById(id);
        return optionalBrand.isPresent() ? optionalBrand.get() : null;
    }

    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    public Brand update(Integer id, Brand updatedBrand) {
        Brand brand = getById(id);
        if (brand != null) {
            brand.setId(updatedBrand.getId());
            brand.setName(updatedBrand.getName());
            return brandRepository.save(brand);
        }
        return null;
    }

    public void delete(Integer id) {
        brandRepository.deleteById(id);
    }
}
