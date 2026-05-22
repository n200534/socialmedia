package com.example.socialmedia.controller;

import com.example.socialmedia.dto.PostResponse;
import com.example.socialmedia.dto.UserCreateRequest;
import com.example.socialmedia.dto.UserResponse;
import com.example.socialmedia.dto.UserUpdateRequest;
import com.example.socialmedia.entity.User;
import com.example.socialmedia.service.PostService;
import com.example.socialmedia.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final PostService postService;

    public UserController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }



    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers()
                .stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getUsername(),
                        user.getEmail()
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );
    }

    @PutMapping("/{id}")
    public UserResponse updateUsername(
            @PathVariable Long id,
            @Valid @RequestBody UserUpdateRequest request) {

        User updatedUser = userService.updateUsername(
                id,
                request.getUsername()
        );

        return new UserResponse(
                updatedUser.getId(),
                updatedUser.getUsername(),
                updatedUser.getEmail()
        );
    }

    @GetMapping("/{id}/posts")
    public List<PostResponse> getUserPosts(
            @PathVariable Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        return postService.getPostsByUserId(
                id,
                page,
                size
        );
    }
}
