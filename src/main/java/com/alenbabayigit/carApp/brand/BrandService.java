package com.alenbabayigit.carApp.brand;

import java.util.List;

public interface BrandService {
  Brand create(Brand brand);

  Brand getById(String brandId);

  List<Brand> getAll();

  Brand update(String brandId, Brand updatedBrand);

  void delete(String brandId);
}
