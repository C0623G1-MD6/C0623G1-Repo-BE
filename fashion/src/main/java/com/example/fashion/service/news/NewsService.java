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
public class NewsService implements INewsService {
    @Autowired
    private INewsRepository newsRepository;

    @Override
    public List<INewsDto> findAllNews(Integer newsCategoryId, Integer roleId) {
        if (roleId == 1) {
            return newsRepository.sortByManCategory(newsCategoryId);
        } else if (roleId == 2) {
            return newsRepository.sortByWomanCategory(newsCategoryId);
        } else if (roleId == 3) {
            return newsRepository.sortByTipsCategory(newsCategoryId);
        } else if (roleId == 4) {
            return newsRepository.sortByPromotionCategory(newsCategoryId);
        } else {
            return newsRepository.findAllNews(newsCategoryId);
        }
    }

    @Override
    public List<INewsDto> findAllByPromotionCategory() {
        return newsRepository.findAllByPromotionCategory();
    }

    @Override
    public List<INewsDto> findAllByDateCreate() {
        return newsRepository.findAllByDateCreate();
    }

    @Override
    public List<INewsDto> findAllAnotherNews() {
        return newsRepository.findAllAnotherNews();
    }

    @Override
    public void saveNews(News news) {
        newsRepository.saveNews(news);

    }


    @Override
    public INewsDto showNewsDetails(Integer id) {
        return newsRepository.showNewsDetails(id);
    }

    @Override
    public News findById(Integer id) {
        return newsRepository.findById(id).get();
    }
}
