package com.example.fashion.service.warehouse;

import com.example.fashion.dto.warehouse.WarehouseReceiptDetailDto;
import org.springframework.data.repository.query.Param;

public interface IWarehouseDetailService {
    Boolean saveWarehouseDetail(WarehouseReceiptDetailDto warehouseReceiptDetailDto);
    void saveWarehouseDetails(Integer sizeDetailId,
                              Integer inputQuantity,
                               Double inputPrice,
                              Integer warehouseId);
}
