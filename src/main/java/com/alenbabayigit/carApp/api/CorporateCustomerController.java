package com.alenbabayigit.carApp.api;

import com.alenbabayigit.carApp.corporatecustomer.CorporateCustomerServiceImpl;
import com.alenbabayigit.carApp.corporatecustomer.model.request.CreateCorporateCustomerRequest;
import com.alenbabayigit.carApp.corporatecustomer.model.request.UpdateCorporateCustomerRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/corporatecustomers")
public class CorporateCustomerController {

    private final CorporateCustomerServiceImpl corporateCustomerService;

    public CorporateCustomerController(CorporateCustomerServiceImpl corporateCustomerService) {
        this.corporateCustomerService = corporateCustomerService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateCorporateCustomerRequest createCorporateCustomerRequest) {
        return corporateCustomerService.create(createCorporateCustomerRequest);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return corporateCustomerService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return corporateCustomerService.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody UpdateCorporateCustomerRequest updateCorporateCustomerRequest) {
        return corporateCustomerService.update(id, updateCorporateCustomerRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return corporateCustomerService.delete(id);
    }

}
