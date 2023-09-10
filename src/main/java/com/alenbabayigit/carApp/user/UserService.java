package com.alenbabayigit.carApp.user;

import com.alenbabayigit.carApp.user.model.request.CreateUserRequest;
import com.alenbabayigit.carApp.user.model.request.UpdateUserRequest;
import com.alenbabayigit.carApp.user.model.response.UserGetByIdResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> create(CreateUserRequest createUserRequest);

    ResponseEntity<?> getById(Integer id);

    ResponseEntity<?> getAll();

    ResponseEntity<?> update(Integer id, UpdateUserRequest updateUserRequest);

    User getUserById(Integer id);

    ResponseEntity<?> delete(Integer id);
}
