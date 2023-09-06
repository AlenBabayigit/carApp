package com.alenbabayigit.carApp.individualcustomer;

import com.alenbabayigit.carApp.exception.BusinessException;
import com.alenbabayigit.carApp.individualcustomer.model.request.CreateIndividualCustomerRequest;
import com.alenbabayigit.carApp.individualcustomer.model.request.UpdateIndividualCustomerRequest;
import com.alenbabayigit.carApp.individualcustomer.model.response.IndividualCustomerGetAllResponse;
import com.alenbabayigit.carApp.individualcustomer.model.response.IndividualCustomerGetByIdResponse;
import com.alenbabayigit.carApp.util.ResponseBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndividualCustomerServiceImpl implements IndividualCustomerService {

    private final IndividualCustomerRepository individualCustomerRepository;

    public IndividualCustomerServiceImpl(IndividualCustomerRepository individualCustomerRepository) {
        this.individualCustomerRepository = individualCustomerRepository;
    }

    @Override
    public IndividualCustomer create(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        checkIndividualCustomerAlreadyExists(createIndividualCustomerRequest.email(), createIndividualCustomerRequest.phoneNumber(), createIndividualCustomerRequest.nationalId());
        IndividualCustomer individualCustomer = new IndividualCustomer();
        individualCustomer.setEmail(createIndividualCustomerRequest.email());
        individualCustomer.setPassword(createIndividualCustomerRequest.password());
        individualCustomer.setPhoneNumber(createIndividualCustomerRequest.phoneNumber());
        individualCustomer.setName(createIndividualCustomerRequest.name());
        individualCustomer.setLastname(createIndividualCustomerRequest.lastname());
        individualCustomer.setNationalId(createIndividualCustomerRequest.nationalId());
        return individualCustomerRepository.save(individualCustomer);
    }

    public void checkIndividualCustomerAlreadyExists(String email, String phoneNumber, String nationalId) {
        boolean isEmailExists = individualCustomerRepository.existsIndividualCustomerByEmailIgnoreCase(email);
        boolean isPhoneNumberExists = individualCustomerRepository.existsIndividualCustomerByPhoneNumber(phoneNumber);
        boolean isNationalIdExists = individualCustomerRepository.existsIndividualCustomerByNationalId(nationalId);
        if (isEmailExists || isPhoneNumberExists || isNationalIdExists) {
            throw new BusinessException("Individual customer already exists with following email, phone number & national id: "
                    + email + ", " + phoneNumber + ", " + nationalId);
        }

    }

    @Override
    public IndividualCustomerGetByIdResponse getById(Integer id) {
        IndividualCustomer individualCustomer = getIndividualCustomerById(id);
        return new IndividualCustomerGetByIdResponse(individualCustomer.getEmail(), individualCustomer.getPassword(),
                individualCustomer.getPhoneNumber(), individualCustomer.getName(), individualCustomer.getLastname(), individualCustomer.getNationalId());
    }

    @Override
    public ResponseEntity<?> getAll() {
    List<IndividualCustomerGetAllResponse> list =
        individualCustomerRepository.findAll().stream()
            .map(
                individualCustomer ->
                    new IndividualCustomerGetAllResponse(
                        individualCustomer.getId(),
                        individualCustomer.getEmail(),
                        individualCustomer.getPassword(),
                        individualCustomer.getPhoneNumber(),
                        individualCustomer.getName(),
                        individualCustomer.getLastname(),
                        individualCustomer.getNationalId())).toList();
        return ResponseBuilder.success("Data listed successfully.", list);

    }

    @Override
    public IndividualCustomer update(Integer id, UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
        checkIndividualCustomerAlreadyExists(updateIndividualCustomerRequest.email(), updateIndividualCustomerRequest.phoneNumber(), updateIndividualCustomerRequest.nationalId());
        IndividualCustomer individualCustomer = getIndividualCustomerById(id);
        individualCustomer.setEmail(updateIndividualCustomerRequest.email());
        individualCustomer.setPassword(updateIndividualCustomerRequest.password());
        individualCustomer.setPhoneNumber(updateIndividualCustomerRequest.phoneNumber());
        individualCustomer.setName(updateIndividualCustomerRequest.name());
        individualCustomer.setLastname(updateIndividualCustomerRequest.lastname());
        individualCustomer.setNationalId(updateIndividualCustomerRequest.nationalId());
        return individualCustomerRepository.save(individualCustomer);
    }

    @Override
    public IndividualCustomer getIndividualCustomerById(Integer id) {
        return individualCustomerRepository.findById(id).orElseThrow(() -> new BusinessException("There is no individual customer with following id: " + id));
    }

    @Override
    public void delete(Integer id) {
        getIndividualCustomerById(id);
        individualCustomerRepository.deleteById(id);
    }
}
