package com.alenbabayigit.carApp.corporatecustomer;


import com.alenbabayigit.carApp.corporatecustomer.model.request.CreateCorporateCustomerRequest;
import com.alenbabayigit.carApp.corporatecustomer.model.request.UpdateCorporateCustomerRequest;
import com.alenbabayigit.carApp.corporatecustomer.model.response.CorporateCustomerGetByIdResponse;
import org.springframework.http.ResponseEntity;

public interface CorporateCustomerService {

    ResponseEntity<?> create(CreateCorporateCustomerRequest createCorporateCustomerRequest);

    ResponseEntity<?> getById(Integer id);

    ResponseEntity<?> getAll();

    ResponseEntity<?> update(Integer id, UpdateCorporateCustomerRequest updateCorporateCustomerRequest);

    CorporateCustomer getCorporateCustomerById(Integer id);

    ResponseEntity<?> delete(Integer id);

}
