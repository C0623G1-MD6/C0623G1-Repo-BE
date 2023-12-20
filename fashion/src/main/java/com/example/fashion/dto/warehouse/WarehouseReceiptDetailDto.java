package com.example.fashion.dto.warehouse;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class WarehouseReceiptDetailDto implements Validator {
    private Integer id;

    private Integer warehouseId;

    private Integer inputQuantity;

    private Double inputPrice;
    private String productName;
    private String sizeName;
    private Integer sizeDetailId;
    private String receiptCode;



    public WarehouseReceiptDetailDto() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getInputQuantity() {
        return inputQuantity;
    }

    public void setInputQuantity(Integer inputQuantity) {
        this.inputQuantity = inputQuantity;
    }

    public Double getInputPrice() {
        return inputPrice;
    }

    public void setInputPrice(Double inputPrice) {
        this.inputPrice = inputPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public Integer getSizeDetailId() {
        return sizeDetailId;
    }

    public void setSizeDetailId(Integer sizeDetailId) {
        this.sizeDetailId = sizeDetailId;
    }

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        WarehouseReceiptDetailDto warehouseReceiptDetailDto = (WarehouseReceiptDetailDto) target;
        if (warehouseReceiptDetailDto.getInputQuantity() == null) {
            errors.rejectValue("inputQuantity", "null", "Vui lòng nhập giá trị lớn hơn 0");
        } else if (warehouseReceiptDetailDto.getInputQuantity() > 2000) {
            errors.rejectValue("inputQuantity", "null", "Vui lòng nhập giá trị bé hơn 2000");
        } else if (warehouseReceiptDetailDto.getInputQuantity() <=0) {
            errors.rejectValue("inputQuantity", "null", "Vui lòng nhập");
        }
        if (warehouseReceiptDetailDto.getInputPrice() == null) {
            errors.rejectValue("inputPrice", "null", "Vui lòng nhập giá trị lớn hơn 0");
        } else if (warehouseReceiptDetailDto.getInputPrice() > 1000000) {
            errors.rejectValue("inputPrice", "null", "Vui lòng nhập giá trị bé hơn 1000000");
        } else if (warehouseReceiptDetailDto.getInputPrice() <=0) {
            errors.rejectValue("inputPrice", "null", "Vui lòng không để trống");
        }
        if (warehouseReceiptDetailDto.getSizeName() == null){
            errors.rejectValue("sizeName", "null", "Vui lòng chọn size ");

        }
        if (warehouseReceiptDetailDto.getProductName() == null){
            errors.rejectValue("productName", "null", "Vui lòng chọn size ");

        }

    }
}
