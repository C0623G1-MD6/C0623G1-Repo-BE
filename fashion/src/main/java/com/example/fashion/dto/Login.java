package com.example.fashion.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Login {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
