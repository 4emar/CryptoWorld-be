package com.crypto.demo.model.Dto;

import lombok.Data;


@Data
public class RegisterDto {

    private String username;

    private String password;

    private String role;
}