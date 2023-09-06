package com.alenbabayigit.carApp.user;

import com.alenbabayigit.carApp.user.model.request.CreateUserRequest;
import com.alenbabayigit.carApp.user.model.request.UpdateUserRequest;
import com.alenbabayigit.carApp.user.model.response.UserGetByIdResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {

    User create(CreateUserRequest createUserRequest);

    UserGetByIdResponse getById(Integer id);

    ResponseEntity<?> getAll();

    User update(Integer id, UpdateUserRequest updateUserRequest);

    User getUserById(Integer id);

    void delete(Integer id);
}
