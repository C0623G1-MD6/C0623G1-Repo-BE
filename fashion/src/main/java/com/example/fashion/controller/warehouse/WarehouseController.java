package com.example.fashion.controller.warehouse;

import com.example.fashion.dto.product.IProductResponse;
import com.example.fashion.dto.product.ISizeDto;
import com.example.fashion.dto.warehouse.WarehouseReceiptDetailDto;
import com.example.fashion.model.warehouse.Warehouse;
import com.example.fashion.service.product.IProductService;
import com.example.fashion.service.product.ISizeDetailService;
import com.example.fashion.service.product.ISizeService;
import com.example.fashion.service.warehouse.IWarehouseDetailService;
import com.example.fashion.service.warehouse.IWarehouseService;
import com.example.fashion.utils.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/warehouses/")
public class WarehouseController {
    @Autowired
    private IWarehouseService warehouseService;
    @Autowired
    private ISizeDetailService sizeDetailService;
    @Autowired
    private IProductService productService;
    @Autowired
    private IWarehouseDetailService warehouseDetailService;
    @Autowired
    private ISizeService sizeService;

    /**
     * created at 14/12/2023
     * LamTV
     * get all list product
     */

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {
        List<IProductResponse> products = productService.getAllProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/inputWarehouseDetail")
    public ResponseEntity<?> saveWarehouse(@RequestBody WarehouseReceiptDetailDto warehouseReceiptDetailDto,
                                                 BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        new WarehouseReceiptDetailDto().validate(warehouseReceiptDetailDto, bindingResult);
        if (bindingResult.hasErrors()) {
            for (FieldError err : bindingResult.getFieldErrors()) {
                errors.put(err.getField(), err.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Warehouse warehouse = new Warehouse();
//        BeanUtils.copyProperties(warehouseReceiptDetailDto, warehouse);
        warehouse.setReceiptCode(CodeGenerator.generateCode());
        warehouse.setReceiptDate(String.valueOf(LocalDate.now()));
        warehouseService.saveWarehouse(warehouse);
        warehouseDetailService.saveWarehouseDetails(warehouseReceiptDetailDto.getSizeDetailId(),
                warehouseReceiptDetailDto.getInputQuantity(),
                warehouseReceiptDetailDto.getInputPrice(),
                warehouse.getId());
        sizeDetailService.updateQuantityWarehouse(warehouseReceiptDetailDto.getInputQuantity(),
                warehouseReceiptDetailDto.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    @PostMapping("/inputWarehouseDetail")
//    public ResponseEntity<Void> saveWarehouseDetail(@RequestBody WarehouseReceiptDto warehouseReceiptDto) {
//        warehouseReceiptDto.setReceiptCode(CodeGenerator.generateCode());
//        Boolean statusWarehouse = warehouseService.createWarehouse(warehouseReceiptDto);
//        if (!statusWarehouse) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        } else {
//            Integer warehouseId = warehouseService.getWarehouseIdByReceiptCode(warehouseReceiptDto.getReceiptCode());
//
//            for (WarehouseReceiptDetailDto warehouseReceiptDetailDto : warehouseReceiptDto.getWarehouseDetailSet()) {
//                warehouseReceiptDetailDto.setWarehouseId(warehouseId);
//                Boolean statusWarehouseDetail = warehouseDetailService.saveWarehouseDetail(warehouseReceiptDetailDto);
//                {
//                    if (!statusWarehouseDetail){
//                        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//                    } else {
//                        sizeDetailService.updateQuantityWarehouse(warehouseReceiptDetailDto.getInputQuantity(),warehouseReceiptDetailDto.getSizeDetailId());
//                    }
//                }
//            }
//        }
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    /**
     * created at 14/12/2023
     * LamTV
     * get code
     */
    @GetMapping("/code")
    public ResponseEntity<?> getCode() {
        String code = CodeGenerator.generateCode();
        return new ResponseEntity<>(code, HttpStatus.OK);
    }

    @GetMapping("/sizes/{productId}")
    public ResponseEntity<List<ISizeDto>> getListSizeByProductCode(@PathVariable Integer productId){
        List<ISizeDto> iSizeDtoList = sizeService.getAllSizes(productId);
        if (iSizeDtoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iSizeDtoList,HttpStatus.OK);
    }
}