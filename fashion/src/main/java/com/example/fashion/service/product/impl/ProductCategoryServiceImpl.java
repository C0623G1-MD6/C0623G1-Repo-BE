package com.example.fashion.service.product.impl;

import com.example.fashion.repository.product.IProductCategoryRepository;
import com.example.fashion.repository.product.IProductRepository;
import com.example.fashion.service.product.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceImpl implements IProductCategoryService {
    @Autowired
    private IProductCategoryRepository iProductCategoryRepository;
}
