package com.example.fashion.service.product.impl;

import com.example.fashion.dto.product.IProductDTO;
import com.example.fashion.repository.product.IProductRepository;
import com.example.fashion.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<IProductDTO> getAllProducts(Pageable pageable, String productName, Double minPrice, Double maxPrice, String sizeName) {
        return productRepository.findAll(pageable, productName, minPrice, maxPrice, sizeName);
    }
}
