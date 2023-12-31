package com.alenbabayigit.carApp.user;

import com.alenbabayigit.carApp.exception.BusinessException;
import com.alenbabayigit.carApp.user.model.request.CreateUserRequest;
import com.alenbabayigit.carApp.user.model.request.UpdateUserRequest;
import com.alenbabayigit.carApp.user.model.response.UserGetAllResponse;
import com.alenbabayigit.carApp.user.model.response.UserGetByIdResponse;
import com.alenbabayigit.carApp.util.ResponseBuilder;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<?> create(CreateUserRequest createUserRequest) {
        checkEmailAlreadyExists(createUserRequest.email());
        User user = new User();
        user.setEmail(createUserRequest.email());
        user.setPassword(createUserRequest.password());
        return ResponseBuilder.success("User created successfully.", userRepository.save(user));
    }

    public void checkEmailAlreadyExists(String email) {
        boolean isEmailExists = userRepository.existsUserByEmailIgnoreCase(email);
        if (isEmailExists) {
            throw new BusinessException("Email already exists: " + email);
        }
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        User user = getUserById(id);
        return ResponseBuilder.success("Data listed succesfully.", new UserGetByIdResponse(user.getEmail(), user.getPassword()));
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<UserGetAllResponse> list = userRepository.findAll().stream()
                .map(user -> new UserGetAllResponse(user.getId(), user.getEmail(), user.getPassword())).toList();
        return ResponseBuilder.success("Data listed successfully.", list);
    }

    @Override
    public ResponseEntity<?> update(Integer id, UpdateUserRequest updateUserRequest) {
        checkEmailAlreadyExists(updateUserRequest.email());
        User user = getUserById(id);
        user.setEmail(updateUserRequest.email());
        user.setPassword(updateUserRequest.password());
        return ResponseBuilder.success("User updated successfully.", userRepository.save(user));
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new BusinessException("There is no user with following id: " + id));
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        getUserById(id);
        userRepository.deleteById(id);
        return ResponseBuilder.success("User deleted successfully.", null);
    }
}
