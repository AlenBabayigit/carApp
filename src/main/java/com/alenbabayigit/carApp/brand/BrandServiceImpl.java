package com.alenbabayigit.carApp.brand;

import java.util.List;
import java.util.Optional;

import com.alenbabayigit.carApp.brand.model.request.CreateBrandRequest;
import com.alenbabayigit.carApp.brand.model.request.UpdateBrandRequest;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand create(CreateBrandRequest createBrandRequest) {
        Brand brand = new Brand();
        brand.setName(createBrandRequest.name());
        return brandRepository.save(brand);
    }

    @Override
    public Brand getById(Integer id) {
        Optional<Brand> optionalBrand = brandRepository.findById(id);
        return optionalBrand.orElse(null);
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand update(Integer id, UpdateBrandRequest updateBrandRequest) {
        Brand brand = getBrandById(id);
        brand.setName(updateBrandRequest.name());
        return brandRepository.save(brand);
    }

    private Brand getBrandById(Integer id) {
        return brandRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no brand with following id: " + id));
  }

  @Override
  public void delete(Integer id) {
        getBrandById(id);
        brandRepository.deleteById(id);
    }
}
