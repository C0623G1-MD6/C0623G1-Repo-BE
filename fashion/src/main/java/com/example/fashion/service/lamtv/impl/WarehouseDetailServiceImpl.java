package com.example.fashion.service.lamtv.impl;

import com.example.fashion.repository.warehouse.IWarehouseDetailRepository;
import com.example.fashion.service.lamtv.IWarehouseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseDetailServiceImpl implements IWarehouseDetailService {
    @Autowired
    private IWarehouseDetailRepository warehouseDetailRepository;
    /**
     * @method : Import warehouse
     * @author: LamTV
     * @date: 12/12/2023
     * @param productId product code
     * @param quantity quantity entered
     * @param warehouseId id of warehouse entry
     */
    @Override
    public void saveWarehouseDetail(Integer productId,Integer quantity,Integer warehouseId) {
        warehouseDetailRepository.importWarehouseDetail(productId, quantity, warehouseId);
    }
}
