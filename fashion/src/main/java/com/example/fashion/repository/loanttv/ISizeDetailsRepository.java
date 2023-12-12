package com.example.fashion.repository.loanttv;

import com.example.fashion.model.loanttv.SizeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ISizeDetailsRepository extends JpaRepository<SizeDetails,Integer> {
    /**
     * @author : LamTV
     * @date: 12/12/2023
     * @param productId product code to find size
     * @method : findAll by product_id
     */
    @Query(value = "select sd.size_id,sd.quantity " +
            " from size_details sd " +
            " where sd.product_id =:productId ",nativeQuery = true)
    void findByProductId(@Param("productId") Integer productId);
    /**
     * @author : LamTV
     * @date: 12/12/2023
     * @method : update quantity
     */
    @Modifying
    @Transactional
    @Query(value = "update size_details " +
            " set quantity =:quantityTotal " +
            " where product_id =:productId ",nativeQuery = true)
    void editQuantity(@Param("quantityTotal") Integer quantity,@Param("productId") Integer productId);
}
