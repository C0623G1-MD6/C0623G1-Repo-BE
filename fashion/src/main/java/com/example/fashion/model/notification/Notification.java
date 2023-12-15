package com.example.fashion.model.notification;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String noticePostingDate;

    private String title;
    private String content;
    private Boolean deleted;

    public Notification() {
    }

    public Notification(Integer id, String noticePostingDate, String title, String content, Boolean deleted) {
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
        this.deleted = deleted;
    }
}
