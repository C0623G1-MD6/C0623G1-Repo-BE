package com.example.fashion.service.product;

import com.example.fashion.dto.product.IProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<IProductDTO> getAllProducts(Pageable pageable, String productName, Double minPrice, Double maxPrice, String sizeName);
}
