package com.example.fashion.service.product;

import com.example.fashion.model.product.ProductCategory;

import java.util.List;

public interface IProductCategoryService {
    /**
     * @author LyDTH
     * @date 16/12/2023
     * @goal get all product categories
     * @return list of category
     */
    List<ProductCategory> getAllProductsCategory();
}
