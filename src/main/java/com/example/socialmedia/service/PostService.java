package com.example.socialmedia.service;

import com.example.socialmedia.dto.PostResponse;
import com.example.socialmedia.entity.Post;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public interface PostService {

    Post createPost(@NotBlank String request, String Email);

    List<Post> getAllPosts();

    List<PostResponse> getMyPosts(
            String userEmail,
            int page,
            int size
    );

    List<PostResponse> getPostsByUserId(
            Long userId,
            int page,
            int size
    );
}
