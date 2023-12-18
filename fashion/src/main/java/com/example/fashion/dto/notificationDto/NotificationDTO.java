package com.example.fashion.dto.notificationDto;

import com.example.fashion.model.notification.Notification;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class NotificationDTO implements Validator {
    private Integer id;
    private String noticePostingDate;
    @NotBlank(message = "không để trống")
    @Size(max = 100, message = "Không được dài quá 100 từ")
    private String title;
    @NotBlank(message = "không để trống")
    @Size(max = 1000, message = "Không được dài quá 1000 từ")
    private String content;
    private Boolean deleted;

    public NotificationDTO() {
    }

    public NotificationDTO(Integer id, String noticePostingDate, String title, String content, Boolean deleted) {
        this.id = id;
        this.noticePostingDate = noticePostingDate;
        this.title = title;
        this.content = content;
        this.deleted = deleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoticePostingDate() {
        return noticePostingDate;
    }

    public void setNoticePostingDate(String noticePostingDate) {
        this.noticePostingDate = noticePostingDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        if (deleted == null) {
            this.deleted = true;
        } else {
            this.deleted = deleted;
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        NotificationDTO notificationDTO = (NotificationDTO) target;

    }


}