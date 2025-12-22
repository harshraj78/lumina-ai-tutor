package com.lumina.api.repository;

import com.lumina.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.Optional;

// JpaRepository gives us save(), findAll(), findById() for free!
public interface UserRepository extends JpaRepository<User, UUID> {

    // We add this to find users by email (useful for login later)
    Optional<User> findByEmail(String email);
}