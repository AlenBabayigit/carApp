package com.alenbabayigit.carApp.api;

import com.alenbabayigit.carApp.individualcustomer.IndividualCustomer;
import com.alenbabayigit.carApp.individualcustomer.IndividualCustomerServiceImpl;
import com.alenbabayigit.carApp.individualcustomer.model.request.CreateIndividualCustomerRequest;
import com.alenbabayigit.carApp.individualcustomer.model.request.UpdateIndividualCustomerRequest;
import com.alenbabayigit.carApp.individualcustomer.model.response.IndividualCustomerGetByIdResponse;
import com.alenbabayigit.carApp.user.User;
import com.alenbabayigit.carApp.user.model.request.UpdateUserRequest;
import com.alenbabayigit.carApp.user.model.response.UserGetByIdResponse;
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
    public void delete(@PathVariable Integer id) {
        individualCustomerService.delete(id);
    }

}
