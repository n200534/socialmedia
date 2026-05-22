package com.example.socialmedia.exception;

public class AlreadyLikedException extends RuntimeException {

    public AlreadyLikedException() {
        super("Post already liked");
    }
}