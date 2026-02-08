package com.example.socialmedia.controller;

import com.example.socialmedia.dto.PostCreateRequest;
import com.example.socialmedia.dto.PostResponse;
import com.example.socialmedia.entity.Post;
import com.example.socialmedia.service.PostService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public PostResponse createPost(@Valid @RequestBody PostCreateRequest request,
                                   Authentication authentication) {

        String userEmail = authentication.getName();

        Post post = postService.createPost(request.getContent(), userEmail);

        return new PostResponse(
                post.getId(),
                post.getContent(),
                post.getUser().getUsername(),
                post.getCreatedAt()
        );
    }

    @GetMapping
    public List<PostResponse> getAllPosts() {

        return postService.getAllPosts()
                .stream()
                .map(post -> new PostResponse(
                        post.getId(),
                        post.getContent(),
                        post.getUser().getUsername(),
                        post.getCreatedAt()
                ))
                .collect(Collectors.toList());
    }
}
