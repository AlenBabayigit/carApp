package com.alenbabayigit.carApp.api;

import com.alenbabayigit.carApp.corporatecustomer.CorporateCustomer;
import com.alenbabayigit.carApp.corporatecustomer.CorporateCustomerServiceImpl;
import com.alenbabayigit.carApp.corporatecustomer.model.request.CreateCorporateCustomerRequest;
import com.alenbabayigit.carApp.corporatecustomer.model.request.UpdateCorporateCustomerRequest;
import com.alenbabayigit.carApp.corporatecustomer.model.response.CorporateCustomerGetByIdResponse;
import com.alenbabayigit.carApp.user.User;
import com.alenbabayigit.carApp.user.model.request.UpdateUserRequest;
import com.alenbabayigit.carApp.user.model.response.UserGetByIdResponse;
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
    public CorporateCustomer create(@RequestBody CreateCorporateCustomerRequest createCorporateCustomerRequest) {
        return corporateCustomerService.create(createCorporateCustomerRequest);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return corporateCustomerService.getAll();
    }

    @GetMapping("/{id}")
    public CorporateCustomerGetByIdResponse getById(@PathVariable Integer id) {
        return corporateCustomerService.getById(id);
    }

    @PutMapping("/{id}")
    public CorporateCustomer update(@PathVariable Integer id, @RequestBody UpdateCorporateCustomerRequest updateCorporateCustomerRequest) {
        return corporateCustomerService.update(id, updateCorporateCustomerRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        corporateCustomerService.delete(id);
    }

}
