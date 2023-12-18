package com.example.fashion.repository.product;

import com.example.fashion.model.product.SizeDetail;
import com.example.fashion.model.warehouse.WarehouseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ISizeDetailRepository extends JpaRepository<WarehouseDetail, Integer> {

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



    /**
     *
     * LamTV
     * this method is updates quantity
     *
     */
    @Transactional
    @Modifying
    @Query( value = "update size_details " +
            "set  quantity =:totalQuantity + quantity " +
            "where id =:id",nativeQuery = true)
    void updateQuantity(@Param("totalQuantity") Integer totalQuantity,
                @Param("id") Integer id);

    /**
     *
     * LamTV
     * find by id Size detail
     *
     */

    @Query( value = "select * " +
            "from size_details s " +
            "where s.product_id =:productId and s.size_id=:sizeId ",nativeQuery = true)
    SizeDetail findByProductIdAndSizeId(@Param("productId") Integer productId,
                                        @Param("sizeId") Integer sizeId);

}
