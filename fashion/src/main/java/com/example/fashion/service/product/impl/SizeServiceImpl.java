package com.example.fashion.service.product.impl;

import com.example.fashion.repository.product.ISizeRepository;
import com.example.fashion.service.product.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizeServiceImpl implements ISizeService {
    @Autowired
    private ISizeRepository iSizeRepository;

}
