package com.alenbabayigit.carApp.brand;

import com.alenbabayigit.carApp.brand.model.request.CreateBrandRequest;
import com.alenbabayigit.carApp.brand.model.request.UpdateBrandRequest;
import com.alenbabayigit.carApp.brand.model.response.BrandGetAllResponse;
import com.alenbabayigit.carApp.brand.model.response.BrandGetByIdResponse;

import java.util.List;

public interface BrandService {
  Brand create(CreateBrandRequest createBrandRequest);

  BrandGetByIdResponse getById(Integer id);

  List<BrandGetAllResponse> getAll();

  Brand update(Integer id, UpdateBrandRequest updateBrandRequest);

  void delete(Integer id);
}
