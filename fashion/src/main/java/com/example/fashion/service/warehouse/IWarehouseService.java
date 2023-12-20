package com.example.fashion.service.warehouse;


import com.example.fashion.dto.warehouse.WarehouseReceiptDto;
import com.example.fashion.model.warehouse.Warehouse;

public interface IWarehouseService {
    void saveWarehouse(Warehouse warehouse);
    Boolean createWarehouse(WarehouseReceiptDto warehouseReceiptDto);
    Integer getWarehouseIdByReceiptCode(String receiptCode);
    Warehouse createAndReturnReceipt(String receiptCode);
}
