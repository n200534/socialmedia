package com.example.socialmedia.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCreateRequest {

    @NotBlank(message = "Post content cannot be empty")
    private String content;
}
