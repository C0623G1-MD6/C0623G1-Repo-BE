package com.example.fashion.repository.product;


import com.example.fashion.model.product.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISizeRepository extends JpaRepository<Size, Integer> {
}
