package com.example.fashion.service.product.impl;
import com.example.fashion.model.product.ProductCategory;
import com.example.fashion.repository.product.IProductCategoryRepository;
import com.example.fashion.service.product.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements IProductCategoryService {
    @Autowired
    private IProductCategoryRepository iProductCategoryRepository;


    /**
     * @author LyDTH
     * @date 16/12/2023
     * @goal get all product categories
     * @return list of category
     */
    @Override
    public List<ProductCategory> getAllProductsCategory() {
        return iProductCategoryRepository.getAllProductsCategory();
    }

    /**
     * LoanTTV
     * @return
     */
    @Override
    public List<ProductCategory> getAllCategories() {
        return iProductCategoryRepository.findAll();
    }
}
