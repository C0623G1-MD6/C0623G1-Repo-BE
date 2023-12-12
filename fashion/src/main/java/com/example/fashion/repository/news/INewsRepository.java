package com.example.fashion.repository.news;
import com.example.fashion.model.news.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface INewsRepository extends JpaRepository<News,Integer> {
    /**
     * method findAllNews
     * Create HungHLP
     * Date 11-12-2023
     * return News List
     */

    @Query(value = "SELECT n.id, n.name, n.content, n.image, n.date_create, n.deleted, n.news_category_id FROM news n JOIN news_category nc ON n.news_category_id = nc.id WHERE n.deleted = 0;",
            nativeQuery = true)
    List<News> findAllNews();

    /**
     * method saveNews
     * Create HungHLP
     * Date 11-12-2023
     * return void
     */

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO news (`name`, `content`, `image`, `date_create`, `deleted`, `news_category_id`) " +
            "VALUES (:#{#news.name}, :#{#news.content}, :#{#news.image}, :#{#news.dateCreate}, 0, :#{#news.newsCategory.id})",
            nativeQuery = true)
    void saveNews(@Param("news") News news);

}
