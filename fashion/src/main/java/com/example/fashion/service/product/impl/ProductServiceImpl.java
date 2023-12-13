package com.example.fashion.service.product.impl;

import com.example.fashion.model.product.Product;
import com.example.fashion.repository.product.IProductRepository;
import com.example.fashion.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public Page<Product> findAllProducts(String option, Pageable pageable) {
        Page<Product> productPage = null;
        switch (option) {
            case "price ASC":
                productPage = iProductRepository.findAllProducts("p.price ASC", pageable);
                break;
            case "price DESC":
                productPage = iProductRepository.findAllProducts("p.price DESC", pageable);
                break;
            case "id DESC":
                productPage = iProductRepository.findAllProducts("p.id DESC", pageable);
                break;
        }
        return productPage;

    }

    @Override
    public Page<Product> findAllProductsHasPromotion(String option, Pageable pageable) {
        Page<Product> productPage = null;
        switch (option) {
            case "price ASC":
                productPage = iProductRepository.findAllProductsHasPromotion("p.price ASC", pageable);
                break;
            case "price DESC":
                productPage = iProductRepository.findAllProductsHasPromotion("p.price DESC", pageable);
                break;
            case "id DESC":
                productPage = iProductRepository.findAllProductsHasPromotion("p.id DESC", pageable);
                break;
        }
        return productPage;
    }

    @Override
    public Page<Product> findAllProductsForMen(String option, Pageable pageable) {
        Page<Product> productPage = null;
        switch (option) {
            case "price ASC":
                productPage = iProductRepository.findAllProductsForMen("p.price ASC", pageable);
                break;
            case "price DESC":
                productPage = iProductRepository.findAllProductsForMen("p.price DESC", pageable);
                break;
            case "id DESC":
                productPage = iProductRepository.findAllProductsForMen("p.id DESC", pageable);
                break;
        }
        return productPage;
    }

    @Override
    public Page<Product> findAllProductsForWomen(String option, Pageable pageable) {
        Page<Product> productPage = null;
        switch (option) {
            case "price ASC":
                productPage = iProductRepository.findAllProductsForWomen("p.price ASC", pageable);
                break;
            case "price DESC":
                productPage = iProductRepository.findAllProductsForWomen("p.price DESC", pageable);
                break;
            case "id DESC":
                productPage = iProductRepository.findAllProductsForWomen("p.id DESC", pageable);
                break;
        }
        return productPage;
    }

    @Override
    public Page<Product> findAllProductsByCategory(Integer chosenId, String option, Pageable pageable) {
        Page<Product> productPage = null;
        switch (option) {
            case "price ASC":
                productPage = iProductRepository.findAllProductsByCategory(chosenId,"p.price ASC", pageable);
                break;
            case "price DESC":
                productPage = iProductRepository.findAllProductsByCategory(chosenId,"p.price DESC", pageable);
                break;
            case "id DESC":
                productPage = iProductRepository.findAllProductsByCategory(chosenId,"p.id DESC", pageable);
                break;
        }
        return productPage;
    }

    @Override
    public Page<Product> findAllProductsByName(String name, String option, Pageable pageable) {
        Page<Product> productPage = null;
        switch (option) {
            case "price ASC":
                productPage = iProductRepository.findAllProductsByName(name,"p.price ASC", pageable);
                break;
            case "price DESC":
                productPage = iProductRepository.findAllProductsByName(name,"p.price DESC", pageable);
                break;
            case "id DESC":
                productPage = iProductRepository.findAllProductsByName(name,"p.id DESC", pageable);
                break;
        }
        return productPage;
    }
}
