package com.alenbabayigit.carApp.api;

import com.alenbabayigit.carApp.user.UserServiceImpl;
import com.alenbabayigit.carApp.user.model.request.CreateUserRequest;
import com.alenbabayigit.carApp.user.model.request.UpdateUserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateUserRequest createUserRequest) {
        return userService.create(createUserRequest);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody UpdateUserRequest updateUserRequest) {
        return userService.update(id, updateUserRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return userService.delete(id);
    }
}
