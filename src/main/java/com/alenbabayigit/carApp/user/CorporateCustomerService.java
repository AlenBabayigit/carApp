package com.alenbabayigit.carApp.user;


import com.alenbabayigit.carApp.user.model.request.CreateCorporateCustomerRequest;
import com.alenbabayigit.carApp.user.model.request.UpdateCorporateCustomerRequest;
import com.alenbabayigit.carApp.user.model.response.CorporateCustomerGetByIdResponse;
import org.springframework.http.ResponseEntity;

public interface CorporateCustomerService {

    CorporateCustomer create(CreateCorporateCustomerRequest createCorporateCustomerRequest);

    CorporateCustomerGetByIdResponse getById(Integer id);

    ResponseEntity<?> getAll();

    CorporateCustomer update(Integer id, UpdateCorporateCustomerRequest updateCorporateCustomerRequest);

    CorporateCustomer getCorporateCustomerById(Integer id);

    void delete(Integer id);

}
