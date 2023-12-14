package com.example.fashion.service.product;

import com.example.fashion.model.product.Size;

import java.util.List;
import java.util.Optional;

public interface ISizeService {
    List<Size> getAllSize();

    Optional<Size> findById(Integer id);
}
