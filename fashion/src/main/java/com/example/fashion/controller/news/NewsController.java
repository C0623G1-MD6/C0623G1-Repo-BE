package com.example.fashion.controller.news;

import com.example.fashion.dto.newsdto.NewsDto;
import com.example.fashion.model.news.News;
import com.example.fashion.service.news.INewsService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/news")
@CrossOrigin("**")
@RestController
public class NewsController {
    @Autowired
    private INewsService newsService;

    /**
     * method findAllNews
     * Create HungHLP
     * Date 11-12-2023
     * return News List
     */
    @GetMapping("")
    public ResponseEntity<List<News>> findAll() {
        List<News> newsList = newsService.findAllNews();
        if (newsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(newsList, HttpStatus.OK);
        }
    }

    /**
     * method saveNews
     * Create HungHLP
     * Date 11-12-2023
     * Goal create news
     * return HttpStatus
     */

    @PostMapping("/create")
    @Transactional
    @Modifying
    @ResponseBody
    public ResponseEntity<Object> create(@Valid @RequestBody NewsDto newsDto, BindingResult bindingResult) {
        Map<String, String> newsDtomap = new HashMap<>();
        new NewsDto().validate(newsDto, bindingResult);
        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                newsDtomap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        News news = new News();
        BeanUtils.copyProperties(newsDto, news);
        LocalDateTime dateTime = LocalDateTime.now();
        news.setDateCreate(dateTime);
        newsService.saveNews(news);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

