package com.example.fashion.model.news;
import jakarta.persistence.*;

@Entity

@Table(name = "news_category")
public class NewsCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", columnDefinition = "varchar(255)", nullable = false)
    private String name;
    @Column(name = "deleted", columnDefinition = "bit(1) default 0", nullable = false)
    private boolean deleted;

    public NewsCategory() {
    }

    public NewsCategory(Integer id) {
        this.id = id;
    }

    public NewsCategory(String name, boolean deleted) {
        this.name = name;
        this.deleted = deleted;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
