package com.example.fashion.dto.newsdto;

import com.example.fashion.model.news.NewsCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDateTime;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
public class NewsDto implements Validator {

    private String name;

    private String content;

    private String image;

    private LocalDateTime dateCreate;

    private boolean deleted;
    private Integer newsCategoryId;

    public NewsDto() {
    }

    public NewsDto( String name, String content, String image, LocalDateTime dateCreate, boolean deleted, Integer newsCategoryId) {
        this.name = name;
        this.content = content;
        this.image = image;
        this.dateCreate = dateCreate;
        this.deleted = deleted;
        this.newsCategoryId = newsCategoryId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getNewsCategoryId() {
        return newsCategoryId;
    }

    public void setNewsCategoryId(Integer newsCategoryId) {
        this.newsCategoryId = newsCategoryId;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    private static final String REGEX_NAME = "^[^\\W_]+$";

    @Override
    public void validate(Object target, Errors errors) {
        NewsDto newsDto = (NewsDto) target;
        if (newsDto.getName() == null) {
            errors.rejectValue("name", "", "Vui lòng nhập");
        } else if (newsDto.getName().trim().equals("")) {
            errors.rejectValue("name", "", "Vui lòng nhập");
        } else if (newsDto.getName().length() <= 5) {
            errors.rejectValue("name", "", "Không đủ độ dài");
        } else if (newsDto.getName().length() > 50) {
            errors.rejectValue("name", "", "Tên quá dài, không được quá 200 kí tự");
        } else if (!newsDto.getName().matches(REGEX_NAME)) {
            errors.rejectValue("name", "", "Không đúng định dạng hoặc chứa kí tự đặc biệt");
        }
        if (newsDto.getContent() == null) {
            errors.rejectValue("content", "", "Vui lòng nhập");
        } else if (newsDto.getContent().trim().equals("")) {
            errors.rejectValue("content", "", "Vui lòng nhập");
        } else if (newsDto.getContent().length() <= 5) {
            errors.rejectValue("content", "", "Không đủ độ dài");
        } else if (newsDto.getContent().length() > 2000) {
            errors.rejectValue("content", "", "Nội dung quá dài, không được quá 2000 kí tự");
        }
        if (newsDto.getImage() == null) {
            errors.rejectValue("content", "", "Vui lòng nhập");
        } else if (newsDto.getImage().trim().equals("")) {
            errors.rejectValue("content", "", "Vui lòng nhập");
        } else if (newsDto.getImage().length() > 255) {
            errors.rejectValue("content", "", "Nội dung quá dài, không được quá 255 kí tự");
        }
    }
}
