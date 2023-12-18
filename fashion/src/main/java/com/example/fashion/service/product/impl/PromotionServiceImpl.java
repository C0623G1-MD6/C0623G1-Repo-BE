package com.example.fashion.service.product.impl;

import com.example.fashion.model.product.Promotion;
import com.example.fashion.repository.product.IPromotionRepository;
import com.example.fashion.service.product.IPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements IPromotionService {
    @Autowired
    private IPromotionRepository iPromotionRepository;
    @Override
    public List<Promotion> getAllPromotions() {
        return iPromotionRepository.findAll();
    }
}
