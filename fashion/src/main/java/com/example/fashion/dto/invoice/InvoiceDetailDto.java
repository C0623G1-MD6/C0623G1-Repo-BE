package com.example.fashion.dto.invoice;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class InvoiceDetailDto implements Validator {
    private Integer id;

    private Integer sellingQuantity;
    private Double sellingPrice;

    private Integer invoiceId;

    private Integer sizeDetailId;

    public InvoiceDetailDto() {
    }

    public InvoiceDetailDto(Integer sellingQuantity, Double sellingPrice, Integer invoiceId, Integer sizeDetailId) {
        this.sellingQuantity = sellingQuantity;
        this.sellingPrice = sellingPrice;
        this.invoiceId = invoiceId;
        this.sizeDetailId = sizeDetailId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSellingQuantity() {
        return sellingQuantity;
    }

    public void setSellingQuantity(Integer sellingQuantity) {
        this.sellingQuantity = sellingQuantity;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getSizeDetailId() {
        return sizeDetailId;
    }

    public void setSizeDetailId(Integer sizeDetailId) {
        this.sizeDetailId = sizeDetailId;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        InvoiceDetailDto invoiceDetailDto = (InvoiceDetailDto) target;
        if ("".equals(invoiceDetailDto.getSellingQuantity())) {
            errors.rejectValue("sellingQuantity", null, "Vui lòng nhập số lượng");
        } else if (invoiceDetailDto.getSellingQuantity()<=0){
            errors.rejectValue("sellingQuantity", null, "Số lượng phải lớn hơn 0");
        }

        if ("".equals(invoiceDetailDto.getInvoiceId())) {
            errors.rejectValue("invoiceId", null, "Vui lòng chọn hóa đơn");
        }

        if ("".equals(invoiceDetailDto.getSizeDetailId())) {
            errors.rejectValue("sizeDetailId", null, "Vui lòng chọn size");
        }
    }
}
