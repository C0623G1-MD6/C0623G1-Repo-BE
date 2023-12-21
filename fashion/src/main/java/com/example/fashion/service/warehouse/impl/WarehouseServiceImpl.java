package com.example.fashion.service.warehouse.impl;

import com.example.fashion.dto.warehouse.WarehouseReceiptDto;
import com.example.fashion.model.warehouse.Warehouse;
import com.example.fashion.repository.warehouse.IWarehouseRepository;
import com.example.fashion.service.warehouse.IWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class WarehouseServiceImpl implements IWarehouseService {
    @Autowired
    private IWarehouseRepository warehouseRepository;
    /**
     * @method : Import warehouse
     * @author: LamTV
     * @date: 12/12/2023
     */

    @Override
    public void saveWarehouse(Warehouse warehouse) {

            warehouseRepository.save(warehouse);

    }

    @Override
    public Boolean createWarehouse(WarehouseReceiptDto warehouseReceiptDto) {
        try {
            warehouseRepository.importWarehouse(warehouseReceiptDto.getReceiptCode());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Integer getWarehouseIdByReceiptCode(String receiptCode) {
        try {
            return warehouseRepository.getWarehouseIdByReceiptCode(receiptCode);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Warehouse createAndReturnReceipt(String receiptCode)  {
        Warehouse receipt = new Warehouse();
        receipt.setReceiptCode(receiptCode);
        receipt.setReceiptDate(LocalDateTime.now().toString());
        receipt = warehouseRepository.save(receipt);
        return receipt;
    }
}
