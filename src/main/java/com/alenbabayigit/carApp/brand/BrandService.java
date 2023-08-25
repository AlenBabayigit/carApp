package com.alenbabayigit.carApp.brand;

import com.alenbabayigit.carApp.brand.model.request.CreateBrandRequest;
import com.alenbabayigit.carApp.brand.model.request.UpdateBrandRequest;
import com.alenbabayigit.carApp.brand.model.response.BrandGetByIdResponse;
import org.springframework.http.ResponseEntity;

public interface BrandService {
  Brand create(CreateBrandRequest createBrandRequest);

  BrandGetByIdResponse getById(Integer id);

  ResponseEntity getAll();

  Brand update(Integer id, UpdateBrandRequest updateBrandRequest);

  Brand getBrandById(Integer id);

  void delete(Integer id);
}
