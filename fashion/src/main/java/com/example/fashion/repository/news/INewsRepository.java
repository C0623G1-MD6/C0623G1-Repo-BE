package com.example.fashion.repository.news;
import com.example.fashion.dto.newsdto.INewsDto;
import com.example.fashion.model.news.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


public interface INewsRepository extends JpaRepository<News, Integer> {
    /**
     * method findAllNews
     * Param newsCategoryId
     * Create HungHLP
     * Date 11-12-2023
     * return News List
     */
    @Query(value = "SELECT n.id as id, n.name as name, n.content as content, n.image as image, n.date_create as dateCreate, n.deleted as deleted, n.news_category_id as newsCategoryId" +
            "  FROM news n JOIN news_category nc ON n.news_category_id = nc.id WHERE n.news_category_id like :newsCategoryId AND  n.deleted = 0",
            nativeQuery = true)
    Page<INewsDto> findAllNews(Pageable pageable, @Param("newsCategoryId") Integer newsCategoryId);


    /**
     * method showNewsDetails
     * Param id
     * Create HungHLP
     * Date 11-12-2023
     * return News Object Details
     */
    @Query(value = "SELECT n.id, n.name, n.content, n.image, n.date_create as dateCreate, n.news_category_id as newsCategoryId FROM news n JOIN news_category nc ON n.news_category_id = nc.id WHERE n.deleted = 0 AND n.id = :id",
            nativeQuery = true)
    INewsDto showNewsDetails(@Param("id") Integer id);


    /**
     * method findAllByDateCreate
     * Param no
     * Create HungHLP
     * Date 11-12-2023
     * return News List sort by dateCreate DESC
     */
    @Query(value = "SELECT n.id as id, n.name as name, n.content as content, n.image as image, n.date_create as dateCreate, n.deleted as deleted, n.news_category_id as newsCategoryId\n" +
            "FROM news n JOIN news_category nc ON n.news_category_id = nc.id WHERE n.deleted = 0 ORDER BY n.date_create ASC",
            nativeQuery = true)
    List<INewsDto> findAllByDateCreate();


    /**
     * method findAllByPromotionCategory
     * Param no
     * Create HungHLP
     * Date 11-12-2023
     * return News List sort by Promotion category
     */
    @Query(value = "SELECT n.id, n.name, n.content, n.image, n.date_create as dateCreate, n.deleted, n.news_category_id as newsCategoryId  FROM news n JOIN news_category nc ON n.news_category_id = nc.id WHERE n.news_category_id like 4 AND  n.deleted = 0",
            nativeQuery = true)
    List<INewsDto> findAllByPromotionCategory();

    /**
     * method findAllAnotherNews
     * Param no
     * Create HungHLP
     * Date 11-12-2023
     * return News List
     */
    @Query(value = "SELECT n.id as id, n.name as name, n.content as content, n.image as image, n.date_create as dateCreate, n.deleted as deleted, n.news_category_id as newsCategoryId\n" +
            "FROM news n JOIN news_category nc ON n.news_category_id = nc.id WHERE n.deleted = 0",
            nativeQuery = true)
    List<INewsDto> findAllAnotherNews();


    /**
     * method saveNews
     * Create HungHLP
     * Date 11-12-2023
     * Goal: create Object News
     * return void
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO news (`name`, `content`, `image`, `date_create`, `deleted`, `news_category_id`) " +
            "VALUES (:#{#news.name}, :#{#news.content}, :#{#news.image}, :#{#news.dateCreate}, 0, :#{#news.newsCategory.id})",
            nativeQuery = true)
    void saveNews(@Param("news") News news);


    /**
     * method sortByManCategory
     * Param newsCategoryId
     * Create HungHLP
     * Date 11-12-2023
     * return News List sort by Man category
     */
    @Query(value = "SELECT n.id, n.name, n.content, n.image, n.date_create, n.deleted, n.news_category_id  FROM news n JOIN news_category nc ON n.news_category_id = nc.id WHERE n.news_category_id like 1 AND  n.deleted = 0",
            nativeQuery = true)
    Page<INewsDto> sortByManCategory(Pageable pageable,@Param("newsCategoryId") Integer newsCategoryId);


    /**
     * method sortByWomanCategory
     * Param newsCategoryId
     * Create HungHLP
     * Date 11-12-2023
     * return News List sort by Woman category
     */
    @Query(value = "SELECT n.id, n.name, n.content, n.image, n.date_create, n.deleted, n.news_category_id  FROM news n JOIN news_category nc ON n.news_category_id = nc.id WHERE n.news_category_id like 2 AND  n.deleted = 0",
            nativeQuery = true)
    Page<INewsDto> sortByWomanCategory(Pageable pageable,@Param("newsCategoryId") Integer newsCategoryId);


    /**
     * method sortByTipsCategory
     * Param newsCategoryId
     * Create HungHLP
     * Date 11-12-2023
     * return News List sort by Tips category
     */
    @Query(value = "SELECT n.id, n.name, n.content, n.image, n.date_create, n.deleted, n.news_category_id  FROM news n JOIN news_category nc ON n.news_category_id = nc.id WHERE n.news_category_id like 3 AND  n.deleted = 0",
            nativeQuery = true)
    Page<INewsDto> sortByTipsCategory(Pageable pageable,@Param("newsCategoryId") Integer newsCategoryId);


    /**
     * method sortByPromotionCategory
     * Param newsCategoryId
     * Create HungHLP
     * Date 11-12-2023
     * return News List sort by Promotion category
     */
    @Query(value = "SELECT n.id, n.name, n.content, n.image, n.date_create, n.deleted, n.news_category_id  FROM news n JOIN news_category nc ON n.news_category_id = nc.id WHERE n.news_category_id like 4 AND  n.deleted = 0",
            nativeQuery = true)
    Page<INewsDto> sortByPromotionCategory(Pageable pageable,@Param("newsCategoryId") Integer newsCategoryId);

}
