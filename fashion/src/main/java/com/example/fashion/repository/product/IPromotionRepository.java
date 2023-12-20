package com.example.fashion.repository.product;

import com.example.fashion.model.product.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPromotionRepository extends JpaRepository<Promotion, Integer> {
    @Query(nativeQuery = true, value = "select * from promotions")
    List<Promotion> findAll();
}
