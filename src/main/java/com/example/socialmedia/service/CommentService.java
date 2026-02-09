package com.example.socialmedia.service;

import com.example.socialmedia.entity.Comment;

import java.util.List;

public interface CommentService {

    Comment addComment(Long postId, String content, String userEmail);

    List<Comment> getCommentsByPost(Long postId);
}
