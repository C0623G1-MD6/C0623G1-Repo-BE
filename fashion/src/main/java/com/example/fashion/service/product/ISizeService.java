package com.example.fashion.service.product;

import com.example.fashion.dto.product.ISizeDto;

import java.util.List;

import com.example.fashion.model.product.Size;

import java.util.List;
import java.util.Optional;

public interface ISizeService {
    List<ISizeDto> getListSizeByProductCode(String productCode);
    List<Size> getAllSize();

//    Optional<Size> findById(Integer id);
}
