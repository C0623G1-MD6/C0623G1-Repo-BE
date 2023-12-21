package com.example.fashion.service.news;

import com.example.fashion.dto.newsdto.INewsDto;
import com.example.fashion.dto.newsdto.NewsDto;
import com.example.fashion.model.news.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface INewsService {
    Page<INewsDto> findAllNews(Pageable pageable, Integer newsCategoryId, Integer roleId);

    List<INewsDto> findAllByPromotionCategory();

    List<INewsDto> findAllByDateCreate();

    List<INewsDto> findAllAnotherNews();

    void saveNews(News news);

    INewsDto showNewsDetails(Integer id);

    News findById(Integer id);

}
