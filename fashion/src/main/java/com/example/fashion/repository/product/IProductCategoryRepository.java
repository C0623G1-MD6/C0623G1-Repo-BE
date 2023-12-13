package com.example.fashion.repository.product;

import com.example.fashion.model.product.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
}
