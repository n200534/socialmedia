package com.example.socialmedia.controller;

import com.example.socialmedia.service.LikeService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts/{postId}/likes")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping
    public void likePost(@PathVariable Long postId,
                         Authentication authentication) {

        String userEmail = authentication.getName();
        likeService.likePost(postId, userEmail);
    }

    @DeleteMapping
    public void unlikePost(@PathVariable Long postId,
                           Authentication authentication) {

        String userEmail = authentication.getName();
        likeService.unlikePost(postId, userEmail);
    }

    @GetMapping("/count")
    public long getLikeCount(@PathVariable Long postId) {
        return likeService.getLikeCount(postId);
    }
}
