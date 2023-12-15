package com.example.fashion.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
public class ChangePassword implements Validator {

    @NotBlank(message = "Trường username không được để trống.")
    private String username;

    @NotBlank(message = "Trường password không được để trống.")
    private String password;

    @Size(min = 8,message = "Mật khẩu mới phải trên 8 kí tự")
    @Size(max = 100,message = "Không được nhiều hơn 100 ký tự")
    @NotBlank(message = "Trường mật khẩu mới không được để trống.")
    private String passwordNew;

    @NotBlank(message = "Trường nhập lại mật khẩu mới không được để trống.")
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
