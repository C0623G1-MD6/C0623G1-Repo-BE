package com.example.fashion.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@NoArgsConstructor
public class ChangePassword implements Validator {

    @NotBlank(message = "Trường username không được để trống.")
    @Size(min = 8,message = "Username phải trên 8 kí tự")
    @Size(max = 30,message = "Username không được nhiều hơn 30 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$",message = "Chỉ được chứa ký tự alphabet, số và dấu gạch dưới")
    private String username;

    @NotBlank(message = "Trường password không được để trống.")
    @Size(min = 8,message = "Password phải trên 8 kí tự")
    @Size(max = 30,message = "Password không được nhiều hơn 100 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$",message = "Chỉ được chứa ký tự alphabet, số và dấu gạch dưới")
    private String password;

    @Size(min = 8,message = "Mật khẩu mới phải trên 8 kí tự")
    @Size(max = 100,message = "Mật khẩu mới không được nhiều hơn 100 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$",message = "Chỉ được chứa ký tự alphabet, số và dấu gạch dưới")
    private String passwordNew;

    @Size(min = 8,message = "Trường nhập lại mật khẩu mới phải trên 8 kí tự")
    @Size(max = 100,message = "Trường nhập lại mật khẩu không nhiều hơn 100 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$",message = "Chỉ được chứa ký tự alphabet, số và dấu gạch dưới")
    private String passwordNewAgain;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    /**
     * Validates the ChangePassword object.
     * @author: ThanhPV
     * @date: 12/12/2023
     * @param target The object to be validated.
     * @param errors The errors object to record validation errors.
     */
    @Override
    public void validate(Object target, Errors errors) {
        ChangePassword changePassword = (ChangePassword) target;
        if (!changePassword.getPasswordNew().equals(changePassword.getPasswordNewAgain())) {
            errors.rejectValue("passwordNewAgain", null, "Mật khẩu nhập lại không khớp.");
        }
    }
}
