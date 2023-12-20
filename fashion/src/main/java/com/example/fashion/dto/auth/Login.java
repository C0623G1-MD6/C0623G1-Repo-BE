package com.example.fashion.dto.auth;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
public class Login implements Validator  {

    @NotBlank(message = "Trường username không được để trống.")
    @NotNull(message = "Trường username không được null")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$",message = "Chỉ được chứa ký tự alphabet, số và dấu gạch dưới")
    @Size(min = 8,message = "Username phải trên 8 kí tự")
    @Size(max = 100,message = "Username phải ít hơn 100 ký tự")
    private String username;

    @NotBlank(message = "Trường password không được để trống.")
    @NotNull(message = "Trường password không được null")
    @Size(min = 8,message = "Mật khẩu phải trên 8 kí tự")
    @Size(max = 100,message = "Mật khẩu phải ít hơn 100 ký tự")
    private String password;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
