package com.example.fashion.dto.notificationDto;

import org.springframework.validation.Errors;

public class ValidateNotificationDTO {
    private static final String NOT_EMTY = "Không được để trống";
    private static final String CHAR_LENGTH_GREATER_HUNDRED = "Số lượng ký tự bé hơn hoặc bằng 1000";
    private static final String TITLE = "title";
    private static final String CONTENT = "content";

    public static void checkValidateNotificationTitle(String title, Errors errors){
        if (title == null || title.trim().length() == 0){
            errors.rejectValue(TITLE, "", NOT_EMTY);
        } else if (title.length()>1000) {
            errors.rejectValue(TITLE,"",CHAR_LENGTH_GREATER_HUNDRED);
        }
    }
    public static void checkValidateNotificationContent(String content, Errors errors){
        if (content == null || content.trim().length() == 0){
            errors.rejectValue(CONTENT, "", NOT_EMTY);
        } else if (content.length()>1000) {
            errors.rejectValue(CONTENT,"",CHAR_LENGTH_GREATER_HUNDRED);
        }
    }
}
