package com.example.fashion.service.product;

import com.example.fashion.model.product.SizeDetail;

public interface ISizeDetailService {
    void save(Integer productId, Integer sizeId);

    void updateQuantity(Integer totalQuantity,Integer id);
    SizeDetail findByProductIdAndSizeId(Integer productId,Integer sizeId);
}
