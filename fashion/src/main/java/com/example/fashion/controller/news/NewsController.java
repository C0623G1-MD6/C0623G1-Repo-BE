package com.example.fashion.controller.news;

import com.example.fashion.dto.newsdto.INewsDto;
import com.example.fashion.dto.newsdto.NewsDto;
import com.example.fashion.model.news.News;
import com.example.fashion.model.news.NewsCategory;
import com.example.fashion.service.news.INewsCategoryService;
import com.example.fashion.service.news.INewsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/news")
@CrossOrigin("*")
@RestController
public class NewsController {
    @Autowired
    private INewsService newsService;
    @Autowired
    private INewsCategoryService newsCategoryService;

    /**
     * method findAllNews
     * Create HungHLP
     * Date 11-12-2023
     * Goal show News List
     * return News List
     */
    @GetMapping("/{newsCategoryId}/{roleId}/{page}")
    public ResponseEntity<Page<INewsDto>> findAll(@PathVariable(name = "newsCategoryId") Integer newsCategoryId,
                                                  @PathVariable(name = "roleId" ) Integer roleId,
                                                  @PathVariable(name = "page", required = false) Integer page) {
        if (newsCategoryService.findById(newsCategoryId).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = PageRequest.of(page, 8);
        Page<INewsDto> newsList = newsService.findAllNews(pageable, newsCategoryId, roleId);
        if (newsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(newsList, HttpStatus.OK);
        }
    }

    /**
     * method findAllByDateCreate
     * Create HungHLP
     * Date 11-12-2023
     * Goal show News List sort by date create DESC
     * return List sort by date create DESC
     */
    @GetMapping("/date")
    public ResponseEntity<List<INewsDto>> findAllByDateCreate() {
        List<INewsDto> newsList = newsService.findAllByDateCreate();
        if (newsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(newsList, HttpStatus.OK);
        }
    }

    /**
     * method findAllByPromotionCategory
     * Create HungHLP
     * Date 11-12-2023
     * Goal show News List sort by Category Promotion
     * return List Category Promotion
     */
    @GetMapping("/promotion")
    public ResponseEntity<List<INewsDto>> findAllByPromotionCategory() {
        List<INewsDto> newsList = newsService.findAllByPromotionCategory();
        if (newsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(newsList, HttpStatus.OK);
        }
    }


    /**
     * method findAllAnotherNews
     * Param no
     * Create HungHLP
     * Date 11-12-2023
     * return News List
     */
    @GetMapping("/another")
    public ResponseEntity<List<INewsDto>> findAllAnotherNews() {
        List<INewsDto> newsList = newsService.findAllAnotherNews();
        if (newsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(newsList, HttpStatus.OK);
        }
    }

    /**
     * method showNewsDetails
     * Param id
     * Create HungHLP
     * Date 11-12-2023
     * return News Object Details
     */
    @GetMapping("/details/{id}")
    public ResponseEntity<INewsDto> showNewsDetails(@PathVariable Integer id) {
        News news = newsService.findById(id);
        if (news == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            INewsDto iNewsDto = newsService.showNewsDetails(id);
            return new ResponseEntity<>(iNewsDto, HttpStatus.OK);
        }
    }

    /**
     * method saveNews
     * Create HungHLP
     * Date 11-12-2023
     * Goal create news
     * return HttpStatus
     **/
    @PostMapping("/create")
    public ResponseEntity<Object> create(@Valid @RequestBody NewsDto newsDto) {
        News news = new News();
        news.setDeleted(false);
        news.setDateCreate(newsDto.getDateCreate());
        news.setName(newsDto.getName());
        news.setImage(newsDto.getImage());
        news.setContent(newsDto.getContent());
        news.setNewsCategory(new NewsCategory(newsDto.getNewsCategoryId()));
        newsService.saveNews(news);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

