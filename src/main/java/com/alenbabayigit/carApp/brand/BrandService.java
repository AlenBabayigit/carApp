package com.alenbabayigit.carApp.brand;

import com.alenbabayigit.carApp.brand.model.request.CreateBrandRequest;
import com.alenbabayigit.carApp.brand.model.request.UpdateBrandRequest;
import org.springframework.http.ResponseEntity;

public interface BrandService {
  ResponseEntity<?> create(CreateBrandRequest createBrandRequest);

  ResponseEntity<?> getById(Integer id);

  ResponseEntity<?> getAll();

  ResponseEntity<?> update(Integer id, UpdateBrandRequest updateBrandRequest);

  Brand getBrandById(Integer id);

  ResponseEntity<?> delete(Integer id);
}
