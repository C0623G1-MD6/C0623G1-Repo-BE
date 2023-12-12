package com.example.fashion.service.news;

import com.example.fashion.model.news.News;

import java.util.List;

public interface INewsService {
    List<News> findAllNews();
    void saveNews(News news);
}
