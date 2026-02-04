package com.example.socialmedia.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateRequest {
    private String username;
    private String email;
    private String password;
}
