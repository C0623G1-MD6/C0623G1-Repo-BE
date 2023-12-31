package com.example.fashion.dto.product;

import com.example.fashion.service.product.IProductService;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class ProductDTO implements Validator {
    private Integer id;

    @NotBlank(message = "Vui lòng nhập mã sản phẩm")
    @Pattern(regexp = "^[A-Z]-[0-9]{4}$", message = "Mã sản phẩm không đúng định dạng A-XXXX (A là các chữ cái in hoa từ A-Z, X là các chữ số từ 0-9")
    private String productCode;
    @NotBlank(message = "Vui lòng nhập tên sản phẩm")
    @Pattern(regexp = "^[\\p{L} .'-]+$", message = "Tên sản phẩm chỉ được chứa chữ cái")
    @Size(min = 5, message = "Tên sản phẩm không được ít hơn 5 ký tự")
    @Size(max = 50, message = "Tên sản phẩm không được quá 50 ký tự")
    private String name;
    
    @NotBlank(message = "Vui lòng nhập mô tả sản phẩm")
    private String description;

    private LocalDateTime createdDate;

    @NotBlank(message = "Vui lòng không để trống ảnh sản phẩm")
    private String productImage;

    @NotBlank(message = "Vui lòng không để trống mã QR sản phẩm")
    private String qrCode;

    @NotNull(message = "Vui lòng chọn giới tính")
    private Boolean gender;

    @NotNull(message = "Vui lòng nhập giá sản phẩm")
    @Min(value = 100000, message = "Giá sản phẩm không được thấp hơn 100.000 VND")
    private Double price;

    @NotNull(message = "Vui lòng chọn phân loại")
    private Integer categoryId;
    @NotNull(message = "Vui lòng chọn kích thước")
    private List<Integer> sizeId;

    @NotNull(message = "Vui lòng chọn mã giảm giá")
    private Integer promotionId;

    private IProductService productService;

    public ProductDTO() {
    }

    public ProductDTO(Integer id, String productCode, String name, String description, LocalDateTime createdDate,
                      String productImage, String qrCode, Boolean gender, Double price, Integer categoryId,
                      List<Integer> sizeId, Integer promotionId, IProductService productService) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.description = description;
        this.createdDate = createdDate;
        this.productImage = productImage;
        this.qrCode = qrCode;
        this.gender = gender;
        this.price = price;
        this.categoryId = categoryId;
        this.sizeId = sizeId;
        this.promotionId = promotionId;
        this.productService = productService;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public List<Integer> getSizeId() {
        return sizeId;
    }


    public void setProductService(IProductService productService) {
        this.productService = productService;
    }

    public void setSizeId(List<Integer> sizeId) {
        this.sizeId = sizeId;
    }

    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return ProductDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDTO productDTO = (ProductDTO) target;
        IProductDTO iProductDTO = productService.findByProductCode(productDTO.getProductCode());
        if (iProductDTO != null) {
            errors.rejectValue("productCode", "existed", "Mã sản phẩm đã tồn tại!");
        }
    }
}
