package com.example.fashion.repository.product;


import com.example.fashion.dto.product.ISizeDto;
import com.example.fashion.model.product.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISizeRepository extends JpaRepository<Size, Integer> {

    @Query(value = "select s.name from products p join size_details sd on p.id = sd.product_id join sizes s on s.id = sd.size_id\n" +
            "where p.product_code = :productCode group by p.id, s.name", nativeQuery = true)
    List<ISizeDto> getListSizeByProductCode(@Param("productCode") String productCode);
}
