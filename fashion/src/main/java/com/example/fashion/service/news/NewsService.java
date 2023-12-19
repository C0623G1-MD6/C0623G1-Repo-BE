package com.example.fashion.service.news;

import com.example.fashion.dto.newsdto.INewsDto;
import com.example.fashion.dto.newsdto.NewsDto;
import com.example.fashion.model.news.News;
import com.example.fashion.model.news.NewsCategory;
import com.example.fashion.repository.news.INewsRepository;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService implements INewsService {
    @Autowired
    private INewsRepository newsRepository;

    @Override
    public Page<INewsDto> findAllNews(Pageable pageable, Integer newsCategoryId, Integer roleId) {
        if (roleId == 1) {
            return newsRepository.sortByManCategory(pageable,newsCategoryId);
        } else if (roleId == 2) {
            return newsRepository.sortByWomanCategory(pageable,newsCategoryId);
        } else if (roleId == 3) {
            return newsRepository.sortByTipsCategory(pageable,newsCategoryId);
        } else if (roleId == 4) {
            return newsRepository.sortByPromotionCategory(pageable,newsCategoryId);
        } else {
            return newsRepository.findAllNews(pageable,newsCategoryId);
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
        String content = news.getContent().trim().replaceAll("\\s+", " ");
        news.setContent(content);
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
