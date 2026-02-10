package com.example.socialmedia.service;

public interface FollowService {

    void followUser(Long userIdToFollow, String followerEmail);

    void unfollowUser(Long userIdToUnfollow, String followerEmail);

    long getFollowersCount(Long userId);

    long getFollowingCount(Long userId);
}
