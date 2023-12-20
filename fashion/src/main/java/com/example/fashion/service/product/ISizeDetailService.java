package com.example.fashion.service.product;

import com.example.fashion.model.product.SizeDetail;

import com.example.fashion.dto.product.ISizeDetailDto;

public interface ISizeDetailService {
    /**
     * created at 12/12/2023
     * LoanTTV
     * @param productId
     * @param sizeId
     */
    void save(Integer productId, Integer sizeId);

    void updateQuantityWarehouse(Integer totalQuantity,Integer id);
    SizeDetail findByProductIdAndSizeId(String productId, String sizeId);
    ISizeDetailDto getQuantityByProductCodeAndSizeName(String productCode, String sizeName);

    Boolean updateQuantity(Integer sellingQuantity, Integer sizeDetailId);
}
