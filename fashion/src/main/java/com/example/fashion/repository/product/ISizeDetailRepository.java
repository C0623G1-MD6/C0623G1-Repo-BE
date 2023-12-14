package com.example.fashion.repository.product;

import com.example.fashion.dto.product.ProductDTO;
import com.example.fashion.model.product.SizeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ISizeDetailRepository extends JpaRepository<SizeDetail, Integer> {

    /**
     * created at 12/12/2023
     * LoanTTV
     * this method is used to insert productId and sizeId into table size_details
     * @param productId
     * @param sizeId
     */
    @Transactional
    @Modifying
    @Query (nativeQuery = true, value = "insert into size_details (product_id, size_id) values (:productId, :sizeId)")
    void save(Integer productId, Integer sizeId);
}
