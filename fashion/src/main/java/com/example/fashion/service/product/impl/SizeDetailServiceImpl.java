package com.example.fashion.service.product.impl;

import com.example.fashion.repository.product.ISizeDetailRepository;
import com.example.fashion.service.product.ISizeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizeDetailServiceImpl implements ISizeDetailService {
    @Autowired
    private ISizeDetailRepository iSizeDetailRepository;
}
