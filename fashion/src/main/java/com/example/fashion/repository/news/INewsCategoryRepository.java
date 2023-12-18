package com.example.fashion.repository.news;

import com.example.fashion.model.news.News;
import com.example.fashion.model.news.NewsCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface INewsCategoryRepository extends JpaRepository<NewsCategory,Integer> {

}
