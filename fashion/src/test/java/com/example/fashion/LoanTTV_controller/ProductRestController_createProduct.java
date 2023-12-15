package com.example.fashion.LoanTTV_controller;

import com.example.fashion.dto.product.ProductDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductRestController_createProduct {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * LoanTTV
     * This method is used to test for function createProduct in case productName is null.
     * @throws Exception
     */
    @Test
    public void createProduct_ProductName_13() throws Exception {
        List<Integer> sizeDetails = new ArrayList<>();
        sizeDetails.add(1);
        sizeDetails.add(2);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(null);
        productDTO.setProductCode("B-0001");
        productDTO.setProductImage("abc");
        productDTO.setQrCode("abc");
        productDTO.setGender(true);
        productDTO.setPrice(100000d);
        productDTO.setCategoryId(2);
        productDTO.setSizeId(sizeDetails);
        productDTO.setPromotionId(2);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
                .content(this.objectMapper.writeValueAsString(productDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * LoanTTV
     * This method is used to test for function createProduct in case productName is empty.
     * @throws Exception
     */
    @Test
    public void createProduct_ProductName_14() throws Exception {
        List<Integer> sizeDetails = new ArrayList<>();
        sizeDetails.add(1);
        sizeDetails.add(2);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("");
        productDTO.setProductCode("B-0001");
        productDTO.setProductImage("abc");
        productDTO.setQrCode("abc");
        productDTO.setGender(true);
        productDTO.setPrice(100000d);
        productDTO.setCategoryId(2);
        productDTO.setSizeId(sizeDetails);
        productDTO.setPromotionId(2);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * LoanTTV
     * This method is used to test for function createProduct in case productName format is wrong .
     * @throws Exception
     */
    @Test
    public void createProduct_ProductName_15() throws Exception {
        List<Integer> sizeDetails = new ArrayList<>();
        sizeDetails.add(1);
        sizeDetails.add(2);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("abc@");
        productDTO.setProductCode("B-0001");
        productDTO.setProductImage("abc");
        productDTO.setQrCode("abc");
        productDTO.setGender(true);
        productDTO.setPrice(100000d);
        productDTO.setCategoryId(2);
        productDTO.setSizeId(sizeDetails);
        productDTO.setPromotionId(2);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * LoanTTV
     * This method is used to test for function createProduct with min length of productName.
     * @throws Exception
     */
    @Test
    public void createProduct_ProductName_16() throws Exception {
        List<Integer> sizeDetails = new ArrayList<>();
        sizeDetails.add(1);
        sizeDetails.add(2);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("a");
        productDTO.setProductCode("B-0001");
        productDTO.setProductImage("abc");
        productDTO.setQrCode("abc");
        productDTO.setGender(true);
        productDTO.setPrice(100000d);
        productDTO.setCategoryId(2);
        productDTO.setSizeId(sizeDetails);
        productDTO.setPromotionId(2);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * LoanTTV
     * This method is used to test for function createProduct with max length of productName.
     * @throws Exception
     */
    @Test
    public void createProduct_ProductName_17() throws Exception {
        List<Integer> sizeDetails = new ArrayList<>();
        sizeDetails.add(1);
        sizeDetails.add(2);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Áo Khoác ANORAK Giả Da Dáng Ngắn May Chần Bông Áo Khoác ANORAK Giả Da Dáng Ngắn May Chần Bông");
        productDTO.setProductCode("B-0001");
        productDTO.setProductImage("abc");
        productDTO.setQrCode("abc");
        productDTO.setGender(true);
        productDTO.setPrice(100000d);
        productDTO.setCategoryId(2);
        productDTO.setSizeId(sizeDetails);
        productDTO.setPromotionId(2);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * LoanTTV
     * This method is used to test for function createProduct with input param (productCode is null).
     * @throws Exception
     */
    @Test
    public void createProduct_ProductCode_13() throws Exception {
        List<Integer> sizeDetails = new ArrayList<>();
        sizeDetails.add(1);
        sizeDetails.add(2);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Áo Khoác ANORAK Giả Da Dáng Ngắn May Chần Bông");
        productDTO.setProductCode(null);
        productDTO.setProductImage("abc");
        productDTO.setQrCode("abc");
        productDTO.setGender(true);
        productDTO.setPrice(100000d);
        productDTO.setCategoryId(2);
        productDTO.setSizeId(sizeDetails);
        productDTO.setPromotionId(2);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * LoanTTV
     * This method is used to test for function createProduct with input param (productCode is empty).
     * @throws Exception
     */
    @Test
    public void createProduct_ProductCode_14() throws Exception {
        List<Integer> sizeDetails = new ArrayList<>();
        sizeDetails.add(1);
        sizeDetails.add(2);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Áo Khoác ANORAK Giả Da Dáng Ngắn May Chần Bông");
        productDTO.setProductCode("");
        productDTO.setProductImage("abc");
        productDTO.setQrCode("abc");
        productDTO.setGender(true);
        productDTO.setPrice(100000d);
        productDTO.setCategoryId(2);
        productDTO.setSizeId(sizeDetails);
        productDTO.setPromotionId(2);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * LoanTTV
     * This method is used to test for function createProduct with input param (productCode format is  wrong).
     * @throws Exception
     */
    @Test
    public void createProduct_ProductCode_15() throws Exception {
        List<Integer> sizeDetails = new ArrayList<>();
        sizeDetails.add(1);
        sizeDetails.add(2);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Áo Khoác ANORAK Giả Da Dáng Ngắn May Chần Bông");
        productDTO.setProductCode("A-00");
        productDTO.setProductImage("abc");
        productDTO.setQrCode("abc");
        productDTO.setGender(true);
        productDTO.setPrice(100000d);
        productDTO.setCategoryId(2);
        productDTO.setSizeId(sizeDetails);
        productDTO.setPromotionId(2);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * LoanTTV
     * This method is used to test for function createProduct with input param (productImage is null).
     * @throws Exception
     */
    @Test
    public void createProduct_ProductImage_13() throws Exception {
        List<Integer> sizeDetails = new ArrayList<>();
        sizeDetails.add(1);
        sizeDetails.add(2);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Áo Khoác ANORAK Giả Da Dáng Ngắn May Chần Bông");
        productDTO.setProductCode("B-0004");
        productDTO.setProductImage(null);
        productDTO.setQrCode("abc");
        productDTO.setGender(true);
        productDTO.setPrice(100000d);
        productDTO.setCategoryId(2);
        productDTO.setSizeId(sizeDetails);
        productDTO.setPromotionId(2);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * LoanTTV
     * This method is used to test for function createProduct with input param (QRCode is null).
     * @throws Exception
     */
    @Test
    public void createProduct_QRCode_13() throws Exception {
        List<Integer> sizeDetails = new ArrayList<>();
        sizeDetails.add(1);
        sizeDetails.add(2);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Áo Khoác ANORAK Giả Da Dáng Ngắn May Chần Bông");
        productDTO.setProductCode("B-0004");
        productDTO.setProductImage("abc");
        productDTO.setQrCode(null);
        productDTO.setGender(true);
        productDTO.setPrice(100000d);
        productDTO.setCategoryId(2);
        productDTO.setSizeId(sizeDetails);
        productDTO.setPromotionId(2);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * LoanTTV
     * This method is used to test for function createProduct with input param (Gender is null).
     * @throws Exception
     */
    @Test
    public void createProduct_Gender_13() throws Exception {
        List<Integer> sizeDetails = new ArrayList<>();
        sizeDetails.add(1);
        sizeDetails.add(2);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Áo Khoác ANORAK Giả Da Dáng Ngắn May Chần Bông");
        productDTO.setProductCode("B-0004");
        productDTO.setProductImage("abc");
        productDTO.setQrCode("abc");
        productDTO.setGender(null);
        productDTO.setPrice(100000d);
        productDTO.setCategoryId(2);
        productDTO.setSizeId(sizeDetails);
        productDTO.setPromotionId(2);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * LoanTTV
     * This method is used to test for function createProduct with input param (productPrice is null).
     * @throws Exception
     */
    @Test
    public void createProduct_Price_13() throws Exception {
        List<Integer> sizeDetails = new ArrayList<>();
        sizeDetails.add(1);
        sizeDetails.add(2);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Áo Khoác ANORAK Giả Da Dáng Ngắn May Chần Bông");
        productDTO.setProductCode("B-0004");
        productDTO.setProductImage("abc");
        productDTO.setQrCode("abc");
        productDTO.setGender(true);
        productDTO.setPrice(null);
        productDTO.setCategoryId(2);
        productDTO.setSizeId(sizeDetails);
        productDTO.setPromotionId(2);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * LoanTTV
     * This method is used to test for function createProduct with input param (Price) less than min price.
     * @throws Exception
     */
    @Test
    public void createProduct_Price_16() throws Exception {
        List<Integer> sizeDetails = new ArrayList<>();
        sizeDetails.add(1);
        sizeDetails.add(2);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Áo Khoác ANORAK Giả Da Dáng Ngắn May Chần Bông");
        productDTO.setProductCode("B-0004");
        productDTO.setProductImage("abc");
        productDTO.setQrCode("abc");
        productDTO.setGender(true);
        productDTO.setPrice(10000d);
        productDTO.setCategoryId(2);
        productDTO.setSizeId(sizeDetails);
        productDTO.setPromotionId(2);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * LoanTTV
     * This method is used to test for function createProduct with input param (Price) greater than max price.
     * @throws Exception
     */
    @Test
    public void createProduct_Price_17() throws Exception {
        List<Integer> sizeDetails = new ArrayList<>();
        sizeDetails.add(1);
        sizeDetails.add(2);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Áo Khoác ANORAK Giả Da Dáng Ngắn May Chần Bông");
        productDTO.setProductCode("B-0004");
        productDTO.setProductImage("abc");
        productDTO.setQrCode("abc");
        productDTO.setGender(true);
        productDTO.setPrice(200000000d);
        productDTO.setCategoryId(2);
        productDTO.setSizeId(sizeDetails);
        productDTO.setPromotionId(2);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * LoanTTV
     * This method is used to test for function createProduct with input param (CategoryId is null).
     * @throws Exception
     */
    @Test
    public void createProduct_CategoryId_13() throws Exception {
        List<Integer> sizeDetails = new ArrayList<>();
        sizeDetails.add(1);
        sizeDetails.add(2);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Áo Khoác ANORAK Giả Da Dáng Ngắn May Chần Bông");
        productDTO.setProductCode("B-0004");
        productDTO.setProductImage("abc");
        productDTO.setQrCode("abc");
        productDTO.setGender(true);
        productDTO.setPrice(700000d);
        productDTO.setCategoryId(null);
        productDTO.setSizeId(sizeDetails);
        productDTO.setPromotionId(2);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * LoanTTV
     * This method is used to test for function createProduct with input param (SizeId is null).
     * @throws Exception
     */
    @Test
    public void createProduct_SizeId_13() throws Exception {
        List<Integer> sizeDetails = new ArrayList<>();
        sizeDetails.add(1);
        sizeDetails.add(2);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Áo Khoác ANORAK Giả Da Dáng Ngắn May Chần Bông");
        productDTO.setProductCode("B-0004");
        productDTO.setProductImage("abc");
        productDTO.setQrCode("abc");
        productDTO.setGender(true);
        productDTO.setPrice(700000d);
        productDTO.setCategoryId(2);
        productDTO.setSizeId(null);
        productDTO.setPromotionId(2);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * LoanTTV
     * This method is used to test for function createProduct with input param (PromotionId is null).
     * @throws Exception
     */
    @Test
    public void createProduct_PromotionId_13() throws Exception {
        List<Integer> sizeDetails = new ArrayList<>();
        sizeDetails.add(1);
        sizeDetails.add(2);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Áo Khoác ANORAK Giả Da Dáng Ngắn May Chần Bông");
        productDTO.setProductCode("B-0004");
        productDTO.setProductImage("abc");
        productDTO.setQrCode("abc");
        productDTO.setGender(true);
        productDTO.setPrice(700000d);
        productDTO.setCategoryId(2);
        productDTO.setSizeId(sizeDetails);
        productDTO.setPromotionId(null);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * LoanTTV
     * This method is used to test for function createProduct with successful case.
     * @throws Exception
     */
    @Test
    public void createProduct_18() throws Exception {
        List<Integer> sizeDetails = new ArrayList<>();
        sizeDetails.add(1);
        sizeDetails.add(2);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Áo Khoác ANORAK Giả Da Dáng Ngắn May Chần Bông");
        productDTO.setProductCode("B-0207");
        productDTO.setProductImage("abc");
        productDTO.setQrCode("abc");
        productDTO.setGender(false);
        productDTO.setPrice(700000d);
        productDTO.setCategoryId(2);
        productDTO.setSizeId(sizeDetails);
        productDTO.setPromotionId(4);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
