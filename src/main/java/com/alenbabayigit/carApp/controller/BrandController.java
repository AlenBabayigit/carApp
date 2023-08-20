package com.alenbabayigit.carApp.controller;

import com.alenbabayigit.carApp.entity.Brand;
import com.alenbabayigit.carApp.service.BrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {

    private final BrandServiceImpl brandService;

    @Autowired
    public BrandController(BrandServiceImpl brandService) {
        this.brandService = brandService;
    }

    // Create a new Brand
    @PostMapping
    public Brand createCar(@RequestBody Brand brand) {
        return brandService.createBrand(brand);
    }

    // Get all Brands
    @GetMapping
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

    // Get Brand by ID
    @GetMapping("/{brandID}")
    public Brand getCarById(@PathVariable String brandID) {
        return brandService.getBrandByID(brandID);
    }

    // Update Brand by ID
    @PutMapping("/{brandID}")
    public Brand updateBrand(@PathVariable String brandID, @RequestBody Brand updatedBrand) {
        return brandService.updateBrand(brandID, updatedBrand);
    }

    // Delete all Brands
    @DeleteMapping
    public String deleteAllCars() {
        brandService.deleteAllBrands();
        return "All brands have been deleted successfully.";
    }

    // Delete Brand by ID
    @DeleteMapping("/{brandID}")
    public void deleteCar(@PathVariable String brandID) {
        brandService.deleteBrandByID(brandID);
    }






}
