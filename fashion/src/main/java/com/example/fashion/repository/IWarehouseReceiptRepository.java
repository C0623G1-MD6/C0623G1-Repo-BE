package com.example.fashion.repository;

import com.example.fashion.model.lamtv.WarehouseReceipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWarehouseReceiptRepository extends JpaRepository<WarehouseReceipt,Integer> {
}
