package com.example.fashion.service.product.impl;

import com.example.fashion.dto.product.IProductDTO;
import com.example.fashion.dto.product.ProductDTO;
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

    /**
     * created at 12/12/2023
     * LoanTTV
     * @param productDTO
     */
    @Override
    public void createProduct(ProductDTO productDTO) {
        productRepository.save(productDTO);
    }

    /**
     * created at 12/12/2023
     * LoanTTV
     * @param productCode
     * @return
     */
    @Override
    public IProductDTO findByProductCode(String productCode) {
        return productRepository.findByProductCode(productCode);
    }
}
