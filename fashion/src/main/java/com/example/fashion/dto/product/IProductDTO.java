package com.example.fashion.dto.product;
import java.util.Date;

public interface IProductDTO {
    Integer getProductId();
    String getProductCode();
    String getProductName();
    String getProductDescription();
    Date getCreatedDate();
    String getProductImage();
    Double getProductPrice();
    String getSizeName();
    Integer getProductQuantity();

}
