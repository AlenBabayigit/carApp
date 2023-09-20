package com.alenbabayigit.carApp.api;

import com.alenbabayigit.carApp.brand.BrandService;
import com.alenbabayigit.carApp.brand.model.request.CreateBrandRequest;
import com.alenbabayigit.carApp.brand.model.request.UpdateBrandRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brands")
public class BrandController {

    private final BrandService brandService;
    
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateBrandRequest createBrandRequest) {
        return brandService.create(createBrandRequest);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return brandService.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody UpdateBrandRequest updateBrandRequest) {
        return brandService.update(id, updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return brandService.delete(id);
    }


}
