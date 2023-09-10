package com.alenbabayigit.carApp.brand;

import com.alenbabayigit.carApp.brand.model.request.CreateBrandRequest;
import com.alenbabayigit.carApp.brand.model.request.UpdateBrandRequest;
import com.alenbabayigit.carApp.brand.model.response.BrandGetAllResponse;
import com.alenbabayigit.carApp.brand.model.response.BrandGetByIdResponse;
import com.alenbabayigit.carApp.exception.BusinessException;
import com.alenbabayigit.carApp.util.ResponseBuilder;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public ResponseEntity<?> create(CreateBrandRequest createBrandRequest) {
        checkBrandIsAlreadyExists(createBrandRequest.name());
        Brand brand = new Brand();
        brand.setName(createBrandRequest.name());
        return ResponseBuilder.success("Brand created successfully.", brandRepository.save(brand));
    }

    private void checkBrandIsAlreadyExists(String name) {
        boolean isBrandExists = brandRepository.existsBrandByNameIgnoreCase(name);
        if (isBrandExists) {
            throw new BusinessException("Brand already exists: " + name);
        }
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        Brand brand = getBrandById(id);
        return ResponseBuilder.success("Data listed successfully.", new BrandGetByIdResponse(brand.getName()));
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<BrandGetAllResponse> list = brandRepository.findAll().stream().map(brand -> new BrandGetAllResponse(brand.getId(), brand.getName())).toList();
        return ResponseBuilder.success("Data listed successfully.", list);
    }

    @Override
    public ResponseEntity<?> update(Integer id, UpdateBrandRequest updateBrandRequest) {
        checkBrandIsAlreadyExists(updateBrandRequest.name());
        Brand brand = getBrandById(id);
        brand.setName(updateBrandRequest.name());
        return ResponseBuilder.success("", brandRepository.save(brand));
    }

    @Override
    public Brand getBrandById(Integer id) {
        return brandRepository.findById(id).orElseThrow(() -> new BusinessException("There is no brand with following id: " + id));
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        getBrandById(id);
        brandRepository.deleteById(id);
        return ResponseBuilder.success("Brand deleted successfully.", null);
    }
}
