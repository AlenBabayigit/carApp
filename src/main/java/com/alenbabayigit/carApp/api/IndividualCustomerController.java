package com.alenbabayigit.carApp.api;

import com.alenbabayigit.carApp.individualcustomer.IndividualCustomerServiceImpl;
import com.alenbabayigit.carApp.individualcustomer.model.request.CreateIndividualCustomerRequest;
import com.alenbabayigit.carApp.individualcustomer.model.request.UpdateIndividualCustomerRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/individualcustomers")
public class IndividualCustomerController {

    private final IndividualCustomerServiceImpl individualCustomerService;

    public IndividualCustomerController(IndividualCustomerServiceImpl individualCustomerService) {
        this.individualCustomerService = individualCustomerService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        return individualCustomerService.create(createIndividualCustomerRequest);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return individualCustomerService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return individualCustomerService.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
        return individualCustomerService.update(id, updateIndividualCustomerRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return individualCustomerService.delete(id);
    }

}
