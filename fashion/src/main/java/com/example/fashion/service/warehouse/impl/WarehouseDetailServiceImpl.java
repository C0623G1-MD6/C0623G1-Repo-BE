package com.example.fashion.service.warehouse.impl;

import com.example.fashion.dto.warehouse.WarehouseReceiptDetailDto;
import com.example.fashion.repository.warehouse.IWarehouseDetailRepository;
import com.example.fashion.service.warehouse.IWarehouseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseDetailServiceImpl implements IWarehouseDetailService {
    @Autowired
    private IWarehouseDetailRepository warehouseDetailRepository;

    /**
     * @method : Import warehouse detail
     * @author: LamTV
     * @date: 12/12/2023
     */
    @Override
    public Boolean saveWarehouseDetail(WarehouseReceiptDetailDto warehouseReceiptDetailDto) {
        try {
            warehouseDetailRepository.importWarehouseDetail(warehouseReceiptDetailDto.getSizeDetailId(), warehouseReceiptDetailDto.getInputQuantity(), warehouseReceiptDetailDto.getInputPrice(), warehouseReceiptDetailDto.getWarehouseId());
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public void saveWarehouseDetails(Integer sizeDetailId, Integer inputQuantity, Double inputPrice, Integer warehouseId) {
        warehouseDetailRepository.importWarehouseDetail(sizeDetailId, inputQuantity, inputPrice, warehouseId);
    }

}
