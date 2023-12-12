package com.example.fashion.dto.lamtv;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class WarehouseDetailDTO implements Validator {
    private String receiptCode;
    private String receiptDate;
    private Double inputPrice;
    private Integer inputQuantity;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        WarehouseDetailDTO warehouseDetailDTO = (WarehouseDetailDTO) target;

    }
}
