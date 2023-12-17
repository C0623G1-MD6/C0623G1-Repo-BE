package com.example.fashion.repository.product;

import com.example.fashion.model.product.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    /**
     * @author LyDTH
     * @date 16/12/2023
     * @goal get all product categories
     * @return list of category
     */
    @Query(nativeQuery = true, value="SELECT * \n" +
            "FROM product_categories")
    List<ProductCategory> getAllProductsCategory();
}
