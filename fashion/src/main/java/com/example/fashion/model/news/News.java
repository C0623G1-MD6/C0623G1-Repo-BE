package com.example.fashion.model.news;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;


@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", columnDefinition = "varchar(255)", nullable = false)
    private String name;
    @Column(name = "content", columnDefinition = "longtext", nullable = false)
    private String content;
    @Column(name = "image", columnDefinition = "varchar(255)", nullable = false)
    private String image;
    @Column(name = "date_create", columnDefinition = "datetime", nullable = false)
    private LocalDateTime dateCreate;
    @Column(name = "deleted", columnDefinition = "bit(1) default 0", nullable = false)
    private boolean deleted;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "news_category_id",referencedColumnName = "id",nullable = false)
    private NewsCategory newsCategory;

    public News() {
    }

    public News(String name, String content, String image, LocalDateTime dateCreate, boolean deleted, NewsCategory newsCategory) {
        this.name = name;
        this.content = content;
        this.image = image;
        this.dateCreate = dateCreate;
        this.deleted = deleted;
        this.newsCategory = newsCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public NewsCategory getNewsCategory() {
        return newsCategory;
    }

    public void setNewsCategory(NewsCategory newsCategory) {
        this.newsCategory = newsCategory;
    }
}
