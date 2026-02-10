package com.example.socialmedia.service;

import com.example.socialmedia.entity.Post;
import org.springframework.data.domain.Page;

public interface FeedService {

    Page<Post> getFeed(String userEmail, int page, int size);
}
