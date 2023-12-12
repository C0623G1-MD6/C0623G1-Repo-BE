package com.example.fashion.repository.lamtv.warehouse;

import com.example.fashion.model.lamtv.Warehouse;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IWarehouseRepository extends JpaRepository<Warehouse,Integer> {
    /**
     * @author: LamTV
     * @date: 12/12/2023
     * @method : import warehouse
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO warehouse_receipts (receipt_code,receipt_date) " +
            "VALUES (:code,CURRENT_DATE())", nativeQuery = true)
    void importWarehouse(@Param("code") String code);
}
