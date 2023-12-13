package com.example.fashion.service.warehouse.impl;

import com.example.fashion.repository.warehouse.IWarehouseRepository;
import com.example.fashion.service.warehouse.IWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseServiceImpl implements IWarehouseService {
    @Autowired
    private IWarehouseRepository warehouseRepository;
    /**
     * @method : Import warehouse
     * @author: LamTV
     * @date: 12/12/2023
     * @param code code random unique
     */
    @Override
    public void saveWarehouse(String code) {
        warehouseRepository.importWarehouse(code);
    }
}
