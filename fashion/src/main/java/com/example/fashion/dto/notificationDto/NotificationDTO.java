package com.example.fashion.dto.notificationDto;

import com.example.fashion.model.notification.Notification;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO implements Validator {
    @NotEmpty(message = "Ngày đăng không được để trống")
    private String noticePostingDate;

    @NotNull(message = "Tiêu đề không được null")
    private String title;

    @NotEmpty(message = "Nội dung không được để trống")
    private String content;

    @NotNull(message = "Danh sách vai trò không được null")
    @NotEmpty(message = "Phải chọn ít nhất một vai trò")
    private List<Long> role;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
    @Override
    public void validate(Object target, Errors errors) {

    }
}
