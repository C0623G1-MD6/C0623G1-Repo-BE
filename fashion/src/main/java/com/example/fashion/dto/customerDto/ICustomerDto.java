package com.example.fashion.dto.customerDto;

import com.example.fashion.model.customer.CustomerType;

public interface ICustomerDto {
    Integer getId();

    String getName();

    String getCustomer_code();

    String getPhone();

    Integer getPoint();

    boolean getIs_deleted();

    Double getDiscount_percent();
}
