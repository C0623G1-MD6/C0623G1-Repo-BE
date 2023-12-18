package com.example.fashion.dto.newsdto;

import java.time.LocalDateTime;

public interface INewsDto {
    Integer getId();

    String getName();

    String getContent();

    String getImage();

    LocalDateTime getDateCreate();

    Integer getNewsCategoryId();

}
