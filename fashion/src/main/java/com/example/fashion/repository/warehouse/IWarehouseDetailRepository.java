package com.example.fashion.repository.warehouse;

import com.example.fashion.model.warehouse.WarehouseDetail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IWarehouseDetailRepository extends JpaRepository<WarehouseDetail, Integer> {
    /**
     * @author: LamTV
     * @date: 12/12/2023
     * @method : import warehouse detail
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO warehouse_receipt_details (size_detail_id, input_quantity, input_price, warehouse_receipt_id ) " +
            "VALUES (:sizeDetailId, :inputQuantity, :inputPrice , :warehouseId)", nativeQuery = true)
    void importWarehouseDetail(@Param("sizeDetailId") Integer sizeDetailId,
                               @Param("inputQuantity") Integer inputQuantity,
                               @Param("inputPrice") Double inputPrice,
                               @Param("warehouseId") Integer warehouseId);
}
