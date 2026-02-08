package com.example.socialmedia.service;

import com.example.socialmedia.entity.Post;

import java.util.List;

public interface PostService {

    Post createPost(String content, String userEmail);

    List<Post> getAllPosts();
}
