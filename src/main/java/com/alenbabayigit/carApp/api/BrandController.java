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

    @PostMapping
    public Brand create(@RequestBody Brand brand) {
        return brandService.create(brand);
    }

    @GetMapping
    public List<Brand> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public Brand getById(@PathVariable Integer id) {
        return brandService.getById(id);
    }

    @PutMapping("/{id}")
    public Brand update(@PathVariable Integer id, @RequestBody Brand updatedBrand) {
        return brandService.update(id, updatedBrand);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        brandService.delete(id);
    }


}
