package com.example.fashion.service.product.impl;

import com.example.fashion.dto.product.IProductDTO;
import com.example.fashion.dto.product.ProductDTO;
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
    @Autowired
    private IProductRepository productRepository;
    /**
     * created at 12/12/2023
     * LoanTTV
     * This method is used to get all products with these input parameters
     * @param pageable
     * @param productName
     * @param minPrice
     * @param maxPrice
     * @param sizeName
     * @return Page<IProductDTO>
     */
    @Override
    public Page<IProductDTO> getAllProducts(Pageable pageable, String productName, Double minPrice, Double maxPrice, String sizeName) {
        return productRepository.findAll(pageable, productName, minPrice, maxPrice, sizeName);
    }

    @Override
    public void createProduct(ProductDTO productDTO) {
        productRepository.save(productDTO);
    }

    @Override
    public IProductDTO findByProductCode(String productCode) {
        return productRepository.findByProductCode(productCode);
    }

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