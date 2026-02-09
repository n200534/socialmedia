package com.example.socialmedia.controller;

import com.example.socialmedia.dto.CommentCreateRequest;
import com.example.socialmedia.dto.CommentResponse;
import com.example.socialmedia.entity.Comment;
import com.example.socialmedia.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts/{postId}/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public CommentResponse addComment(@PathVariable Long postId,
                                      @Valid @RequestBody CommentCreateRequest request,
                                      Authentication authentication) {

        String userEmail = authentication.getName();

        Comment comment = commentService.addComment(
                postId,
                request.getContent(),
                userEmail
        );

        return new CommentResponse(
                comment.getId(),
                comment.getContent(),
                comment.getUser().getUsername(),
                comment.getCreatedAt()
        );
    }

    @GetMapping
    public List<CommentResponse> getComments(@PathVariable Long postId) {

        return commentService.getCommentsByPost(postId)
                .stream()
                .map(comment -> new CommentResponse(
                        comment.getId(),
                        comment.getContent(),
                        comment.getUser().getUsername(),
                        comment.getCreatedAt()
                ))
                .collect(Collectors.toList());
    }
}
