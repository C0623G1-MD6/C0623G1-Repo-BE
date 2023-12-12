package com.example.fashion.service.news;

import com.example.fashion.model.news.News;
import com.example.fashion.model.news.NewsCategory;
import com.example.fashion.repository.news.INewsCategoryRepository;
import com.example.fashion.repository.news.INewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsCategoryService implements INewsCategoryService{
    @Autowired
    private INewsCategoryRepository newsCategoryRepository;

    @Override
    public List<NewsCategory> findAllNewsCategory() {
        return newsCategoryRepository.findAll();
    }


}
