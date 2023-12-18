package com.example.fashion.dto.warehouse;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Set;

public class WarehouseReceiptDto implements Validator {
    private Integer id;

    private String receiptCode;

    private String receiptDate;

    private Set<WarehouseReceiptDetailDto> warehouseDetailSet;

    public WarehouseReceiptDto() {
    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<WarehouseReceiptDetailDto> getWarehouseDetailSet() {
        return warehouseDetailSet;
    }

    public void setWarehouseDetailSet(Set<WarehouseReceiptDetailDto> warehouseDetailSet) {
        this.warehouseDetailSet = warehouseDetailSet;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        WarehouseReceiptDto warehouseReceiptDto = (WarehouseReceiptDto) target;
        if ("".equals(warehouseReceiptDto.getReceiptCode())) {
            errors.rejectValue("receiptCode", null, "Vui lòng nhập mã đơn hàng");
        }

        if ("".equals(warehouseReceiptDto.getReceiptDate())) {
            errors.rejectValue("receiptDate", null, "Vui lòng chọn ngày giờ");
        }
    }
}
