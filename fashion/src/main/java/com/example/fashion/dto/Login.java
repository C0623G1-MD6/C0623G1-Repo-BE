package com.example.fashion.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
public class Login implements Validator  {

    @NotBlank
    private String username;
    @NotBlank
    private String password;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
