package com.lumina.api.service;

import com.lumina.api.model.User;
import com.lumina.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User registerNewUser(User user) {
        // The Chef takes the order and puts it in the Filing Cabinet
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        // The Chef fetches everything from the Filing Cabinet
        return userRepository.findAll();
    }
}