package com.example.gistest.dto;

import com.example.gistest.entity.Role;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RegistrationRequest {
    private final String login;
    private final String password;
    private final Role role;
}
