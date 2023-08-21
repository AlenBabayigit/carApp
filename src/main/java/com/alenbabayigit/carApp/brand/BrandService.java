package com.alenbabayigit.carApp.brand;

import com.alenbabayigit.carApp.brand.model.request.CreateBrandRequest;
import com.alenbabayigit.carApp.brand.model.request.UpdateBrandRequest;

import java.util.List;

public interface BrandService {
  Brand create(CreateBrandRequest createBrandRequest);

  Brand getById(Integer id);

  List<Brand> getAll();

  Brand update(Integer id, UpdateBrandRequest updateBrandRequest);

  void delete(Integer id);
}
