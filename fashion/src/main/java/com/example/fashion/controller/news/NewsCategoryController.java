package com.example.fashion.controller.news;

import com.example.fashion.dto.newsdto.NewsDto;
import com.example.fashion.model.news.NewsCategory;
import com.example.fashion.service.news.INewsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("api/category")
public class NewsCategoryController {
    @Autowired
    private INewsCategoryService newsCategoryService;

    @GetMapping("")
    public ResponseEntity<List<NewsCategory>> findAll() {
        List<NewsCategory>newsList = newsCategoryService.findAllNewsCategory();
        if (newsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(newsList, HttpStatus.OK);
        }
    }


}
