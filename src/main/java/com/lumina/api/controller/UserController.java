package com.lumina.api.controller;

import com.lumina.api.model.User;
import com.lumina.api.service.UserService; // 1. We import the Service now
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    // 2. We remove the UserRepository and replace it with UserService
    private final UserService userService;

    @PostMapping
    public User register(@RequestBody User user) {
        // 3. Instead of .save(), we call the service method
        return userService.registerNewUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        // 4. We will need to add this method to our UserService next!
        return userService.getAllUsers();
    }
}