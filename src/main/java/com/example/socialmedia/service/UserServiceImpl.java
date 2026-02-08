package com.example.socialmedia.service;

import com.example.socialmedia.entity.User;
import com.example.socialmedia.exception.InvalidCredentialsException;
import com.example.socialmedia.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository,
                            PasswordEncoder passwordEncoder) {
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public User createUser(User user) {
        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User Not Found"));
    }

    @Override
    public User login(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(InvalidCredentialsException::new);

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidCredentialsException();
        }

        return user;
    }

}

