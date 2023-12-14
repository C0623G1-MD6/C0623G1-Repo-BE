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
    public Page<Product> findAllProducts(String option,Pageable pageable) {
        Page<Product> productPage = null;
        switch (option) {
            case "price ASC":
                return productPage = iProductRepository.findAllProducts("p.price ASC", pageable);
            case "price DESC" :
                return productPage = iProductRepository.findAllProducts("p.price DESC", pageable);
            case "id DESC" :
                return productPage = iProductRepository.findAllProducts("p.id DESC", pageable);

        }
        return productPage;

    }

    @Override
    public Page<Product> findAllProductsByDescId(Pageable pageable) {
        return iProductRepository.findAllProductsByDescId(pageable);
    }

    @Override
    public Page<Product> findAllProductsHasPromotion(Pageable pageable) {
        return iProductRepository.findAllProductsHasPromotion(pageable);
    }

    @Override
    public Page<Product> findAllProductsForMen(Pageable pageable) {
        return iProductRepository.findAllProductsForMen(pageable);
    }

    @Override
    public Page<Product> findAllProductsForWomen(Pageable pageable) {
        return iProductRepository.findAllProductsForWomen(pageable);
    }

    @Override
    public Page<Product> findAllProductsByCategory(Integer chosenId, Pageable pageable) {
        return iProductRepository.findAllProductsByCategory(chosenId, pageable);
    }

    @Override
    public Page<Product> findAllProductsByName(String name, Pageable pageable) {
        return iProductRepository.findAllProductsByName(name, pageable);
    }
}
