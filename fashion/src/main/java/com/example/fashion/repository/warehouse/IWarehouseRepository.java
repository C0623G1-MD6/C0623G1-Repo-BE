package com.example.fashion.repository.warehouse;

import com.example.fashion.model.warehouse.Warehouse;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IWarehouseRepository extends JpaRepository<Warehouse, Integer> {
    /**
     * @author: LamTV
     * @date: 12/12/2023
     * @method : import warehouse
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO warehouse_receipts (receipt_code, receipt_date) " +
            "VALUES ( :receiptCode, CURRENT_DATE())", nativeQuery = true)
    void importWarehouse(@Param("receiptCode") String receiptCode);
    /**
     * The method help to get recieiptId from database.
     * @author LamTV
     * @since 2023-12-17
     */
    @Query(value = "select warehouse_receipts.id from warehouse_receipts where warehouse_receipts.receipt_code = :receiptCode",nativeQuery = true)
    Integer getWarehouseIdByReceiptCode(@Param("receiptCode") String receiptCode);

}
