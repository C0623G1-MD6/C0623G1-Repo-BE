package com.example.fashion.controller.warehouse;

import com.example.fashion.dto.product.IProductResponse;
import com.example.fashion.dto.product.ISizeDto;
import com.example.fashion.dto.warehouse.WarehouseReceiptDetailDto;
import com.example.fashion.dto.warehouse.WarehouseReceiptDto;
import com.example.fashion.model.product.Product;
import com.example.fashion.model.product.SizeDetail;
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

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/warehouses")
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
    public ResponseEntity<List<IProductResponse>> getAllProducts() {
        List<IProductResponse> products = productService.getAllProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    /**
     * created at 16/12/2023
     * LamTV
     * add warehouse
     */
//    @PostMapping("/inputWarehouseDetail")
//    public ResponseEntity<Void> saveWarehouse(@RequestBody WarehouseReceiptDetailDto warehouseReceiptDetailDto,
//                                                 BindingResult bindingResult) {
//        Map<String, String> errors = new HashMap<>();
//        Warehouse warehouse = new Warehouse();
//        warehouse.setReceiptCode(warehouseReceiptDetailDto.getReceiptCode());
//        warehouse.setReceiptDate(String.valueOf(LocalDateTime.now()));
//        warehouseService.saveWarehouse(warehouse);
//        new WarehouseReceiptDetailDto().validate(warehouseReceiptDetailDto, bindingResult);
//        if (bindingResult.hasErrors()) {
//            for (FieldError err : bindingResult.getFieldErrors()) {
//                errors.put(err.getField(), err.getDefaultMessage());
//            }
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        SizeDetail sizeDetail = sizeDetailService.findByProductIdAndSizeId(warehouseReceiptDetailDto.getProductName(), warehouseReceiptDetailDto.getSizeName());
//        warehouseReceiptDetailDto.setSizeDetailId(sizeDetail.getId());
//        warehouseDetailService.saveWarehouseDetails(warehouseReceiptDetailDto.getSizeDetailId(),
//                warehouseReceiptDetailDto.getInputQuantity(),
//                warehouseReceiptDetailDto.getInputPrice(),
//                warehouse.getId());
//        sizeDetailService.updateQuantityWarehouse(warehouseReceiptDetailDto.getInputQuantity(),
//                warehouseReceiptDetailDto.getSizeDetailId());
//        return new ResponseEntity<>(HttpStatus.OK);
//    }


    @PostMapping("/inputWarehouseDetail")
    public ResponseEntity<Void> saveWarehouseDetail(@RequestBody WarehouseReceiptDto warehouseReceiptDto) {
        warehouseReceiptDto.setReceiptCode(warehouseReceiptDto.getReceiptCode());
        Boolean statusWarehouse = warehouseService.createWarehouse(warehouseReceiptDto);
        if (!statusWarehouse) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Integer warehouseId = warehouseService.getWarehouseIdByReceiptCode(warehouseReceiptDto.getReceiptCode());

            for (WarehouseReceiptDetailDto warehouseReceiptDetailDto : warehouseReceiptDto.getWarehouseDetailSet()) {
                warehouseReceiptDetailDto.setWarehouseId(warehouseId);
                SizeDetail sizeDetail = sizeDetailService.findByProductIdAndSizeId(warehouseReceiptDetailDto.getProductName(), warehouseReceiptDetailDto.getSizeName());
                warehouseReceiptDetailDto.setSizeDetailId(sizeDetail.getId());
                Boolean statusWarehouseDetail = warehouseDetailService.saveWarehouseDetail(warehouseReceiptDetailDto);
                {
                    if (!statusWarehouseDetail){
                        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                    } else {
                        sizeDetailService.updateQuantityWarehouse(warehouseReceiptDetailDto.getInputQuantity(),sizeDetail.getId());
                    }
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * created at 14/12/2023
     * LamTV
     * get code
     */
    @GetMapping("/code")
    public ResponseEntity<String> getCode() {
        String code = CodeGenerator.generateCode();
        return new ResponseEntity<>(code, HttpStatus.OK);
    }

    @GetMapping("/sizes/{productName}")
    public ResponseEntity<List<ISizeDto>> getListSizeByProductCode(@PathVariable String productName){
        Product product = productService.findByProductName(productName);
        List<ISizeDto> iSizeDtoList = sizeService.getAllSizes(product.getId());
        if (iSizeDtoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iSizeDtoList,HttpStatus.OK);
    }

    @GetMapping("/product/{productName}")
    public ResponseEntity<Product> getProduct(@PathVariable String productName){
        Product product = productService.findByProductName(productName);
        if (product== null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
}