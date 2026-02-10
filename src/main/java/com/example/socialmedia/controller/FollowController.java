package com.example.socialmedia.controller;

import com.example.socialmedia.service.FollowService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/{userId}")
public class FollowController {

    private final FollowService followService;

    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @PostMapping("/follow")
    public void followUser(@PathVariable Long userId,
                           Authentication authentication) {

        String followerEmail = authentication.getName();
        followService.followUser(userId, followerEmail);
    }

    @DeleteMapping("/unfollow")
    public void unfollowUser(@PathVariable Long userId,
                             Authentication authentication) {

        String followerEmail = authentication.getName();
        followService.unfollowUser(userId, followerEmail);
    }

    @GetMapping("/followers/count")
    public long getFollowersCount(@PathVariable Long userId) {
        return followService.getFollowersCount(userId);
    }

    @GetMapping("/following/count")
    public long getFollowingCount(@PathVariable Long userId) {
        return followService.getFollowingCount(userId);
    }
}