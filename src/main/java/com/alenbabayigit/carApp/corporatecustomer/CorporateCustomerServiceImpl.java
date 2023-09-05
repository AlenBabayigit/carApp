package com.alenbabayigit.carApp.corporatecustomer;

import com.alenbabayigit.carApp.corporatecustomer.model.request.CreateCorporateCustomerRequest;
import com.alenbabayigit.carApp.corporatecustomer.model.request.UpdateCorporateCustomerRequest;
import com.alenbabayigit.carApp.corporatecustomer.model.response.CorporateCustomerGetByIdResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CorporateCustomerServiceImpl implements CorporateCustomerService {
    @Override
    public CorporateCustomer create(CreateCorporateCustomerRequest createCorporateCustomerRequest) {
        return null;
    }

    @Override
    public CorporateCustomerGetByIdResponse getById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> getAll() {
        return null;
    }

    @Override
    public CorporateCustomer update(Integer id, UpdateCorporateCustomerRequest updateCorporateCustomerRequest) {
        return null;
    }

    @Override
    public CorporateCustomer getCorporateCustomerById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
