package com.example.socialmedia.service;

public interface LikeService {

    void likePost(Long postId, String userEmail);

    void unlikePost(Long postId, String userEmail);

    long getLikeCount(Long postId);
}
