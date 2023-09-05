package com.alenbabayigit.carApp.api;

import com.alenbabayigit.carApp.brand.Brand;
import com.alenbabayigit.carApp.brand.BrandServiceImpl;
import com.alenbabayigit.carApp.brand.model.request.CreateBrandRequest;
import com.alenbabayigit.carApp.brand.model.request.UpdateBrandRequest;
import com.alenbabayigit.carApp.brand.model.response.BrandGetByIdResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brands")
public class BrandController {

    private final BrandServiceImpl brandService;
    
    public BrandController(BrandServiceImpl brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    public Brand create(@RequestBody CreateBrandRequest createBrandRequest) {
        return brandService.create(createBrandRequest);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public BrandGetByIdResponse getById(@PathVariable Integer id) {
        return brandService.getById(id);
    }

    @PutMapping("/{id}")
    public Brand update(@PathVariable Integer id, @RequestBody UpdateBrandRequest updateBrandRequest) {
        return brandService.update(id, updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        brandService.delete(id);
    }


}
