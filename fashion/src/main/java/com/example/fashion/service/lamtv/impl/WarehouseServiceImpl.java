package com.example.fashion.service.lamtv.impl;

import com.example.fashion.repository.warehouse.IWarehouseRepository;
import com.example.fashion.service.lamtv.IWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseServiceImpl implements IWarehouseService {
    @Autowired
    private IWarehouseRepository warehouseRepository;
    @Override
    public void saveWarehouse(String code) {
        warehouseRepository.importWarehouse(code);
    }
}
