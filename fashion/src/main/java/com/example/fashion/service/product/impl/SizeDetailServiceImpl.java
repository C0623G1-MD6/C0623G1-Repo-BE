package com.example.fashion.service.product.impl;

import com.example.fashion.repository.product.ISizeDetailRepository;
import com.example.fashion.service.product.ISizeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizeDetailServiceImpl implements ISizeDetailService {
    /**
     * created at 12/12/2023
     * LoanTTV
     */
    @Autowired
    private ISizeDetailRepository sizeDetailRepository;

    /**
     * created at 12/12/2023
     * LoanTTV
     * @param productId
     * @param sizeId
     */
    @Override
    public void save(Integer productId, Integer sizeId) {
        sizeDetailRepository.save(productId, sizeId);
    }
}
