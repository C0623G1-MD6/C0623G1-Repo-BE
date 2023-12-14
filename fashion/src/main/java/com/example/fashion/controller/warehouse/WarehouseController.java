package com.example.fashion.controller.warehouse;

import com.example.fashion.dto.warehouse.WarehouseDetailDTO;
import com.example.fashion.service.warehouse.IWarehouseDetailService;
import com.example.fashion.service.warehouse.IWarehouseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/warehouse")
public class WarehouseController {
    @Autowired
    private IWarehouseService warehouseService;
    @Autowired
    private IWarehouseDetailService warehouseDetailService;

    @PostMapping("/inputWarehouse")
    public ResponseEntity<Object> saveWarehouse(@Valid @RequestBody WarehouseDetailDTO warehouseDetailDTO,
                                                BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        new WarehouseDetailDTO().validate(warehouseDetailDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            for (FieldError err : bindingResult.getFieldErrors()) {
                errors.put(err.getField(), err.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        warehouseService.saveWarehouse(warehouseDetailDTO.getReceiptCode());
        warehouseDetailService.saveWarehouseDetail(warehouseDetailDTO.getProduct(),warehouseDetailDTO.getInputQuantity(),warehouseDetailDTO.getWarehouse());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}