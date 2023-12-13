package com.example.fashion.service.product.impl;

import com.example.fashion.dto.product.IProductDTO;
import com.example.fashion.dto.product.ProductDTO;
import com.example.fashion.dto.product.IProductResponse;
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

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     * @param pageable
     * @return: the page of products
     */
    @Override
    public Page<IProductResponse> findAllProducts( Pageable pageable) {

        return iProductRepository.findAllProducts( pageable);

    }

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     * @param pageable
     * @return: the page of products having promotion greater than 0
     */
    @Override
    public Page<IProductResponse> findAllProductsHasPromotion(Pageable pageable) {

        return iProductRepository.findAllProductsHasPromotion(pageable);
    }

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     * @param pageable
     * @return: the page of products for men
     */
    @Override
    public Page<IProductResponse> findAllProductsForMen(Pageable pageable) {

        return iProductRepository.findAllProductsForMen(pageable);
    }

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     * @param pageable
     * @return: the page of products for women
     */
    @Override
    public Page<IProductResponse> findAllProductsForWomen(Pageable pageable) {

        return iProductRepository.findAllProductsForWomen(pageable);
    }

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     * @param categoryName
     * @param pageable
     * @return the page of products by category name
     */
    @Override
    public Page<IProductResponse> findAllProductsByCategory(String categoryName, Pageable pageable) {

        return iProductRepository.findAllProductsByCategory(categoryName, pageable);
    }

    /**
     * Author: LyDTH
     * Date: 13/12/2023
     * @param name
     * @param pageable
     * @return: the page of products by product name
     */

    @Override
    public Page<IProductResponse> findAllProductsByName(String name, Pageable pageable) {

        return iProductRepository.findAllProductsByName(name,pageable);
    }
}