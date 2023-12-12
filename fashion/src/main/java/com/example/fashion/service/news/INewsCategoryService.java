package com.example.fashion.service.news;
import com.example.fashion.model.news.News;
import com.example.fashion.model.news.NewsCategory;

import java.util.List;

public interface INewsCategoryService {
    List<NewsCategory> findAllNewsCategory();

}
