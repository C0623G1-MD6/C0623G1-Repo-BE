package com.example.fashion.controller.sizeDetail;

import com.example.fashion.dto.size.SizeDetailImport;
import com.example.fashion.model.product.SizeDetail;
import com.example.fashion.model.warehouse.Warehouse;
import com.example.fashion.model.warehouse.WarehouseDetail;
import com.example.fashion.service.product.ISizeDetailService;
import com.example.fashion.service.warehouse.IWarehouseDetailService;
import com.example.fashion.service.warehouse.IWarehouseService;
import com.example.fashion.utils.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/size-detail")
@CrossOrigin("*")
@RestController
public class SizeDetailController {
    @Autowired
    private ISizeDetailService sizeDetailService;
    @Autowired
    private IWarehouseService warehouseService;
    @Autowired
    private IWarehouseDetailService warehouseDetailService;

    @GetMapping
    public ResponseEntity<List<SizeDetail>> getAllSizeDetail() {
        try {
            return new ResponseEntity<>(sizeDetailService.getAllSizeDetail(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveWarehouse(@RequestBody List<SizeDetailImport> sizeDetailImports) {
        try {
            Warehouse warehouse = warehouseService.createAndReturnReceipt(CodeGenerator.generateCode());
            for (SizeDetailImport sizeDetailImport : sizeDetailImports) {
                warehouseDetailService.saveWarehouseDetails(
                        sizeDetailImport.getSizeDetailId(),
                        sizeDetailImport.getInputQuantity(),
                        sizeDetailImport.getInputPrice(),
                        warehouse.getId()
                );
                sizeDetailService.increaseQuantity(sizeDetailImport.getSizeDetailId(),sizeDetailImport.getInputQuantity());
            }
            return new ResponseEntity<>(sizeDetailImports, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
