package com.example.fashion.dto.warehouse;

import jakarta.validation.constraints.NotNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class WarehouseDetailDTO implements Validator {
    private String receiptCode;
    private String receiptDate;
    private Double inputPrice;
    private Integer inputQuantity;
    @NotNull(message = "Vui lòng chọn sản phẩm")
    private Integer productId;
    private Integer warehouseId;
    private static final String PRODUCT_ID_WAREHOUSE_DTO = "productId";
    private static final String INPUT_QUANTITY = "inputQuantity";
    private static final String INPUT_PRICE = "inputPrice";

    public String getReceiptCode() {
        return receiptCode;
    }

    public void setReceiptCode(String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Double getInputPrice() {
        return inputPrice;
    }

    public void setInputPrice(Double inputPrice) {
        this.inputPrice = inputPrice;
    }

    public Integer getInputQuantity() {
        return inputQuantity;
    }

    public void setInputQuantity(Integer inputQuantity) {
        this.inputQuantity = inputQuantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
    /**
     * @author: LamTV
     * @date: 12/12/2023
     * @method : validation data
     */
    @Override
    public void validate(Object target, Errors errors) {
        WarehouseDetailDTO warehouseDetailDTO = (WarehouseDetailDTO) target;
        if (warehouseDetailDTO.getInputQuantity() == null){
            errors.rejectValue(INPUT_QUANTITY, "", "Vui lòng không để trống số lượng");
        }else if (warehouseDetailDTO.getInputQuantity() < 0) {
            errors.rejectValue(INPUT_QUANTITY, "vui lòng nhập số lượng bé hơn 0");
        } else if (warehouseDetailDTO.getInputQuantity() > 2000) {
            errors.rejectValue(INPUT_QUANTITY, "Vui lòng nhập không quá 2000 sản phẩm");
        }
        if (warehouseDetailDTO.getInputPrice() == null){
            errors.rejectValue(INPUT_PRICE, "", "Vui lòng không để trống đơn giá");
        }else if (warehouseDetailDTO.getInputQuantity() < 0) {
            errors.rejectValue(INPUT_PRICE, "vui lòng nhập đơn giá bé hơn 0");
        } else if (warehouseDetailDTO.getInputQuantity() > 1000000000) {
            errors.rejectValue(INPUT_PRICE, "Vui lòng nhập đơn giá không quá 1000000000");
        }
        if (warehouseDetailDTO.getProductId() == null) {
            errors.rejectValue(PRODUCT_ID_WAREHOUSE_DTO, "", "Vui lòng không để trống sản phẩm");
        }
    }
}
