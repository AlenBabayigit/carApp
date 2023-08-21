package com.alenbabayigit.carApp.api;

import com.alenbabayigit.carApp.brand.Brand;
import com.alenbabayigit.carApp.brand.BrandServiceImpl;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brands")
public class BrandController {

    private final BrandServiceImpl brandService;
    
    public BrandController(BrandServiceImpl brandService) {
        this.brandService = brandService;
    }

    // Create a new Brand
    @PostMapping
    public Brand createCar(@RequestBody Brand brand) {
        return brandService.create(brand);
    }

    // Get all Brands
    @GetMapping
    public List<Brand> getAllBrands() {
        return brandService.getAll();
    }

    // Get Brand by ID
    @GetMapping("/{brandID}")
    public Brand getCarById(@PathVariable String brandID) {
        return brandService.getById(brandID);
    }

    // Update Brand by ID
    @PutMapping("/{brandID}")
    public Brand updateBrand(@PathVariable String brandID, @RequestBody Brand updatedBrand) {
        return brandService.update(brandID, updatedBrand);
    }

  

    // Delete Brand by ID
    @DeleteMapping("/{brandID}")
    public void deleteCar(@PathVariable String brandID) {
        brandService.delete(brandID);
    }






}
