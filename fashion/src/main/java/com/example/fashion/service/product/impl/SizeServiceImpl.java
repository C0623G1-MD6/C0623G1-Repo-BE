package com.example.fashion.service.product.impl;

import com.example.fashion.dto.product.ISizeDto;
import com.example.fashion.repository.product.ISizeRepository;
import com.example.fashion.service.product.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeServiceImpl implements ISizeService {
    @Autowired
    private ISizeRepository sizeRepository;

    @Override
    public List<ISizeDto> getListSizeByProductCode(String productCode) {
        try {
            return sizeRepository.getListSizeByProductCode(productCode);
        } catch (Exception e){
            return null;
        }
    }
}
