package com.example.socialmedia.service;
import com.example.socialmedia.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    User login(String email, String password);

    User updateUsername(Long id,String username);

}
