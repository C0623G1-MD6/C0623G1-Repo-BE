package com.example.fashion.repository.product;


import com.example.fashion.model.product.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ISizeRepository extends JpaRepository<Size, Integer> {
    @Query(nativeQuery = true, value = "select * from sizes")
    List<Size> findAll();

    @Query(nativeQuery = true, value = "select name from sizes where id = :sizeId")
    Optional<Size> findSizeBySizeId(Integer sizeId);
}
