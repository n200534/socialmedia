package com.example.socialmedia.repository;

import com.example.socialmedia.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> id(Long id);
    Optional<User> findByEmail(String email);
}
