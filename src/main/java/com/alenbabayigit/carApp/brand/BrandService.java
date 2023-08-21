package com.alenbabayigit.carApp.brand;

import java.util.List;

public interface BrandService {
  Brand create(Brand brand);

  Brand getById(Integer id);

  List<Brand> getAll();

  Brand update(Integer id, Brand updatedBrand);

  void delete(Integer id);
}
