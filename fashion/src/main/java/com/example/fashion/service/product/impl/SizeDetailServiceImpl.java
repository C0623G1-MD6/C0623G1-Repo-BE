package com.example.fashion.service.product.impl;

import com.example.fashion.model.product.SizeDetail;
import com.example.fashion.repository.product.ISizeDetailRepository;
import com.example.fashion.service.product.ISizeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizeDetailServiceImpl implements ISizeDetailService {
    @Autowired
    private ISizeDetailRepository sizeDetailRepository;

    @Override
    public void save(Integer productId, Integer sizeId) {
        sizeDetailRepository.save(productId, sizeId);
    }

    @Override
    public void updateQuantityWarehouse(Integer totalQuantity, Integer id) {
        sizeDetailRepository.updateQuantityWarehouse(totalQuantity,id);
    }

    @Override
    public SizeDetail findByProductIdAndSizeId(Integer productId,Integer sizeId) {
        return sizeDetailRepository.findByProductIdAndSizeId(productId, sizeId);
    }
}
