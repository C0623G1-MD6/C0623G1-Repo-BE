package com.example.fashion.service.product.impl;

import com.example.fashion.dto.product.ISizeDetailDto;
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
    public ISizeDetailDto getQuantityByProductCodeAndSizeName(String productCode, String sizeName) {
        try {
            return sizeDetailRepository.getQuantityByProductCodeAndSizeName(productCode,sizeName);
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public Boolean updateQuantity(Integer sellingQuantity, Integer sizeDetailId) {
        try {
            sizeDetailRepository.updateQuantity(sellingQuantity, sizeDetailId);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
