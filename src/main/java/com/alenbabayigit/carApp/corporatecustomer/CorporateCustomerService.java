package com.alenbabayigit.carApp.corporatecustomer;


import com.alenbabayigit.carApp.corporatecustomer.model.request.CreateCorporateCustomerRequest;
import com.alenbabayigit.carApp.corporatecustomer.model.request.UpdateCorporateCustomerRequest;
import com.alenbabayigit.carApp.corporatecustomer.model.response.CorporateCustomerGetByIdResponse;
import org.springframework.http.ResponseEntity;

public interface CorporateCustomerService {

    CorporateCustomer create(CreateCorporateCustomerRequest createCorporateCustomerRequest);

    CorporateCustomerGetByIdResponse getById(Integer id);

    ResponseEntity<?> getAll();

    CorporateCustomer update(Integer id, UpdateCorporateCustomerRequest updateCorporateCustomerRequest);

    CorporateCustomer getCorporateCustomerById(Integer id);

    void delete(Integer id);

}
