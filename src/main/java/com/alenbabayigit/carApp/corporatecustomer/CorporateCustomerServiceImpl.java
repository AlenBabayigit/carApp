package com.alenbabayigit.carApp.corporatecustomer;

import com.alenbabayigit.carApp.corporatecustomer.model.request.CreateCorporateCustomerRequest;
import com.alenbabayigit.carApp.corporatecustomer.model.request.UpdateCorporateCustomerRequest;
import com.alenbabayigit.carApp.corporatecustomer.model.response.CorporateCustomerGetAllResponse;
import com.alenbabayigit.carApp.corporatecustomer.model.response.CorporateCustomerGetByIdResponse;
import com.alenbabayigit.carApp.exception.BusinessException;
import com.alenbabayigit.carApp.util.ResponseBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorporateCustomerServiceImpl implements CorporateCustomerService {

    private final CorporateCustomerRepository corporateCustomerRepository;

    public CorporateCustomerServiceImpl(CorporateCustomerRepository corporateCustomerRepository) {
        this.corporateCustomerRepository = corporateCustomerRepository;
    }

    @Override
    public CorporateCustomer create(CreateCorporateCustomerRequest createCorporateCustomerRequest) {
        checkCorporateCustomerAlreadyExists(createCorporateCustomerRequest.email(), createCorporateCustomerRequest.phoneNumber(), createCorporateCustomerRequest.taxNumber());
        CorporateCustomer corporateCustomer = new CorporateCustomer();
        corporateCustomer.setEmail(createCorporateCustomerRequest.email());
        corporateCustomer.setPassword(createCorporateCustomerRequest.password());
        corporateCustomer.setPhoneNumber(createCorporateCustomerRequest.phoneNumber());
        corporateCustomer.setCompanyName(createCorporateCustomerRequest.companyName());
        corporateCustomer.setTaxNumber(createCorporateCustomerRequest.taxNumber());
        return corporateCustomerRepository.save(corporateCustomer);
    }

    public void checkCorporateCustomerAlreadyExists(String email, String phoneNumber, String taxNumber) {
        boolean isEmailExists = corporateCustomerRepository.existsCorporateCustomerByEmailIgnoreCase(email);
        boolean isPhoneNumberExists = corporateCustomerRepository.existsCorporateCustomerByPhoneNumber(phoneNumber);
        boolean isTaxNumberExists = corporateCustomerRepository.existsCorporateCustomerByTaxNumber(taxNumber);
        if (isEmailExists || isPhoneNumberExists || isTaxNumberExists) {
            throw new BusinessException("Corporate customer already exists with following email, phone number & tax number: "
                    + email + ", " + phoneNumber + ", " + taxNumber);
        }


    }

    @Override
    public CorporateCustomerGetByIdResponse getById(Integer id) {
        CorporateCustomer corporateCustomer = getCorporateCustomerById(id);
        return new CorporateCustomerGetByIdResponse(corporateCustomer.getEmail(), corporateCustomer.getPassword(),
            corporateCustomer.getPhoneNumber(), corporateCustomer.getCompanyName(), corporateCustomer.getTaxNumber());
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<CorporateCustomerGetAllResponse> list = corporateCustomerRepository.findAll().stream().map(corporateCustomer -> new CorporateCustomerGetAllResponse(corporateCustomer.getId(), corporateCustomer.getEmail(), corporateCustomer.getPassword(), corporateCustomer.getPhoneNumber(), corporateCustomer.getCompanyName(), corporateCustomer.getTaxNumber())).toList();
        return ResponseBuilder.success("Data listed successfully.", list);
    }

    @Override
    public CorporateCustomer update(Integer id, UpdateCorporateCustomerRequest updateCorporateCustomerRequest) {
        checkCorporateCustomerAlreadyExists(
            updateCorporateCustomerRequest.email(),
            updateCorporateCustomerRequest.phoneNumber(),
            updateCorporateCustomerRequest.taxNumber());
        CorporateCustomer corporateCustomer = getCorporateCustomerById(id);
        corporateCustomer.setEmail(updateCorporateCustomerRequest.email());
        corporateCustomer.setPassword(updateCorporateCustomerRequest.password());
        corporateCustomer.setPhoneNumber(updateCorporateCustomerRequest.phoneNumber());
        corporateCustomer.setCompanyName(updateCorporateCustomerRequest.companyName());
        corporateCustomer.setTaxNumber(updateCorporateCustomerRequest.taxNumber());
        return corporateCustomerRepository.save(corporateCustomer);
    }

    @Override
    public CorporateCustomer getCorporateCustomerById(Integer id) {
        return corporateCustomerRepository.findById(id).orElseThrow(() -> new BusinessException("There is no corporate customer with following id: " + id));
    }

    @Override
    public void delete(Integer id) {
        getCorporateCustomerById(id);
        corporateCustomerRepository.deleteById(id);
    }
}
