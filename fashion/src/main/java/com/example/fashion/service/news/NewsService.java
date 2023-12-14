package com.example.fashion.service.news;

import com.example.fashion.dto.newsdto.INewsDto;
import com.example.fashion.dto.newsdto.NewsDto;
import com.example.fashion.model.news.News;
import com.example.fashion.model.news.NewsCategory;
import com.example.fashion.repository.news.INewsRepository;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsService implements INewsService{
    @Autowired
    private INewsRepository newsRepository;
    @Override
    public List<INewsDto> findAllNews(Integer newsCategoryId) {
        return newsRepository.findAllNews(newsCategoryId);
    }

    @Override
    public void saveNews(News news) {
//        NewsCategory newsCategory = new NewsCategory(1);
//        news.setNewsCategory(newsCategory);
        newsRepository.saveNews(news);
//        newsRepository.save(news);
//        newsRepository.save(news);
    }
}
