package com.example.fashion.service.product;

import com.example.fashion.dto.product.ISizeDto;

import java.util.List;

public interface ISizeService {
    List<ISizeDto> getListSizeByProductCode(String productCode);
}
