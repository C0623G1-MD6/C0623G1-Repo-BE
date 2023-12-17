package com.example.fashion.service.product;

import com.example.fashion.dto.product.ISizeDetailDto;

public interface ISizeDetailService {
    void save(Integer productId, Integer sizeId);
    ISizeDetailDto getQuantityByProductCodeAndSizeName(String productCode, String sizeName);

    Boolean updateQuantity(Integer sellingQuantity, Integer sizeDetailId);
}
