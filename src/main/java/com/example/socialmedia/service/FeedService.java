package com.example.socialmedia.service;

import com.example.socialmedia.dto.PostResponse;

import java.util.List;

public interface FeedService {

    List<PostResponse> getFeed(
            String userEmail,
            int page,
            int size
    );
}