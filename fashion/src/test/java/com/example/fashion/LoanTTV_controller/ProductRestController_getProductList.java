package com.example.fashion.LoanTTV_controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductRestController_getProductList {
    private static final String TOKEN_VALID = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcwMjUyNDkxNSwiZXhwIjoxNzg4OTI0OTE1fQ.4FmYt1Lw33dWMoHbvguK7Bi0kjJRFhNCFoP4HmTeRg8";
    @Autowired
    private MockMvc mockMvc;

    /**
     * LoanTTV
     * this method is used to test for function getAllProducts with input param (productName is null)
     * @throws Exception
     */
    @Test
    public void getProductList_productName_7() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/product/list?page=0&size=5&minPrice=1000000&maxPrice=2000000&sizeName=M&sortDirection=desc")
                        .header("Authorization", "Bearer " + TOKEN_VALID))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(3))
                .andExpect(jsonPath("totalElements").value(11))
                .andExpect(jsonPath("content[0].productId").value(17))
                .andExpect(jsonPath("content[0].productCode").value("A-0001"))
                .andExpect(jsonPath("content[0].productName").value("Áo Sơ Mi Vải Poplin"))
                .andExpect(jsonPath("content[0].productPrice").value(1299000.0))
                .andExpect(jsonPath("content[0].productQuantity").value(5))
                .andExpect(jsonPath("content[0].sizeName").value("M"))
                .andExpect(jsonPath("content[4].productId").value(20))
                .andExpect(jsonPath("content[4].productCode").value("A-0004"))
                .andExpect(jsonPath("content[4].productName").value("Quần Lông Ống Suông"))
                .andExpect(jsonPath("content[4].productPrice").value(1990000.0))
                .andExpect(jsonPath("content[4].productQuantity").value(0))
                .andExpect(jsonPath("content[4].sizeName").value("M"));
    }

    /**
     * LoanTTV
     * this method is used to test for function getAllProducts with input param (productName is empty)
     * @throws Exception
     */
    @Test
    public void getProductList_productName_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list?page=0&size=5&productName=&minPrice=1000000&maxPrice=2000000&sizeName=M&sortDirection=desc")
                                .header("Authorization", "Bearer " + TOKEN_VALID))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(3))
                .andExpect(jsonPath("totalElements").value(11))
                .andExpect(jsonPath("content[0].productId").value(17))
                .andExpect(jsonPath("content[0].productCode").value("A-0001"))
                .andExpect(jsonPath("content[0].productName").value("Áo Sơ Mi Vải Poplin"))
                .andExpect(jsonPath("content[0].productPrice").value(1299000.0))
                .andExpect(jsonPath("content[0].productQuantity").value(5))
                .andExpect(jsonPath("content[0].sizeName").value("M"))
                .andExpect(jsonPath("content[4].productId").value(20))
                .andExpect(jsonPath("content[4].productCode").value("A-0004"))
                .andExpect(jsonPath("content[4].productName").value("Quần Lông Ống Suông"))
                .andExpect(jsonPath("content[4].productPrice").value(1990000.0))
                .andExpect(jsonPath("content[4].productQuantity").value(0))
                .andExpect(jsonPath("content[4].sizeName").value("M"));
    }

    /**
     * LoanTTV
     * this method is used to test for function getAllProducts with input param (productName is not existed)
     * @throws Exception
     */
    @Test
    public void getProductList_productName_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list?page=0&size=5&productName=a@&minPrice=1000000&maxPrice=2000000&sizeName=M&sortDirection=desc")
                                .header("Authorization", "Bearer " + TOKEN_VALID))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * LoanTTV
     * this method is used to test for function getAllProducts with input param (productName exists but list size = 0)
     * @throws Exception
     */
    @Test
    public void getProductList_productName_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list?page=0&size=5&productName=a&minPrice=500000&maxPrice=1000000&sizeName=XL&sortDirection=desc")
                                .header("Authorization", "Bearer " + TOKEN_VALID))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * LoanTTV
     * this method is used to test for function getAllProducts with input param (productName exists and list size greater than 0)
     * @throws Exception
     */
    @Test
    public void getProductList_productName_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list?page=0&size=5&productName=Áo&minPrice=1000000&maxPrice=2000000&sizeName=M&sortDirection=desc")
                                .header("Authorization", "Bearer " + TOKEN_VALID))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].productId").value(17))
                .andExpect(jsonPath("content[0].productCode").value("A-0001"))
                .andExpect(jsonPath("content[0].productName").value("Áo Sơ Mi Vải Poplin"))
                .andExpect(jsonPath("content[0].productPrice").value(1299000.0))
                .andExpect(jsonPath("content[0].productQuantity").value(5))
                .andExpect(jsonPath("content[0].sizeName").value("M"))
                .andExpect(jsonPath("content[4].productId").value(27))
                .andExpect(jsonPath("content[4].productCode").value("A-0005"))
                .andExpect(jsonPath("content[4].productName").value("Áo Sơ Mi Thêu Họa Tiết Nổi"))
                .andExpect(jsonPath("content[4].productPrice").value(1699000.0))
                .andExpect(jsonPath("content[4].productQuantity").value(0))
                .andExpect(jsonPath("content[4].sizeName").value("M"));
    }

    /**
     * LoanTTV
     * this method is used to test for function getAllProducts with input param (minPrice and maxPrice are null)
     * @throws Exception
     */
    @Test
    public void getProductList_minPrice_maxPrice_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list?page=0&size=5&productName=Áo&sizeName=M&sortDirection=desc")
                                .header("Authorization", "Bearer " + TOKEN_VALID))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(7))
                .andExpect(jsonPath("content[0].productId").value(17))
                .andExpect(jsonPath("content[0].productCode").value("A-0001"))
                .andExpect(jsonPath("content[0].productName").value("Áo Sơ Mi Vải Poplin"))
                .andExpect(jsonPath("content[0].productPrice").value(1299000.0))
                .andExpect(jsonPath("content[0].productQuantity").value(5))
                .andExpect(jsonPath("content[0].sizeName").value("M"))
                .andExpect(jsonPath("content[4].productId").value(26))
                .andExpect(jsonPath("content[4].productCode").value("AK-0001"))
                .andExpect(jsonPath("content[4].productName").value("Áo Khóa Len Lông Thú"))
                .andExpect(jsonPath("content[4].productPrice").value(3999000.0))
                .andExpect(jsonPath("content[4].productQuantity").value(0))
                .andExpect(jsonPath("content[4].sizeName").value("M"));
    }

    /**
     * LoanTTV
     * this method is used to test for function getAllProducts with input param (minPrice and maxPrice are empty)
     * @throws Exception
     */
    @Test
    public void getProductList_minPrice_maxPrice_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list?page=0&size=5&productName=Áo&minPrice=&maxPrice=&sizeName=M&sortDirection=desc")
                                .header("Authorization", "Bearer " + TOKEN_VALID))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(7))
                .andExpect(jsonPath("content[0].productId").value(17))
                .andExpect(jsonPath("content[0].productCode").value("A-0001"))
                .andExpect(jsonPath("content[0].productName").value("Áo Sơ Mi Vải Poplin"))
                .andExpect(jsonPath("content[0].productPrice").value(1299000.0))
                .andExpect(jsonPath("content[0].productQuantity").value(5))
                .andExpect(jsonPath("content[0].sizeName").value("M"))
                .andExpect(jsonPath("content[4].productId").value(26))
                .andExpect(jsonPath("content[4].productCode").value("AK-0001"))
                .andExpect(jsonPath("content[4].productName").value("Áo Khóa Len Lông Thú"))
                .andExpect(jsonPath("content[4].productPrice").value(3999000.0))
                .andExpect(jsonPath("content[4].productQuantity").value(0))
                .andExpect(jsonPath("content[4].sizeName").value("M"));
    }

    /**
     * LoanTTV
     * this method is used to test for function getAllProducts with input param (minPrice and maxPrice are not existed in database)
     * @throws Exception
     */
    @Test
    public void getProductList_minPrice_maxPrice_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list?page=0&size=5&productName=Áo&minPrice=5000000&maxPrice=10000000&sizeName=M&sortDirection=desc")
                                .header("Authorization", "Bearer " + TOKEN_VALID))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * LoanTTV
     * this method is used to test for function getAllProducts with input param (minPrice and maxPrice are existed but list is empty)
     * @throws Exception
     */
    @Test
    public void getProductList_minPrice_maxPrice_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list?page=0&size=5&productName=Áo&minPrice=500000&maxPrice=1000000&sizeName=XS&sortDirection=desc")
                                .header("Authorization", "Bearer " + TOKEN_VALID))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * LoanTTV
     * this method is used to test for function getAllProducts with input param (minPrice and maxPrice are existed and list size greater than 0)
     * @throws Exception
     */
    @Test
    public void getProductList_minPrice_maxPrice_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list?page=0&size=5&productName=Áo&minPrice=1000000&maxPrice=2000000&sizeName=M&sortDirection=desc")
                                .header("Authorization", "Bearer " + TOKEN_VALID))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].productId").value(17))
                .andExpect(jsonPath("content[0].productCode").value("A-0001"))
                .andExpect(jsonPath("content[0].productName").value("Áo Sơ Mi Vải Poplin"))
                .andExpect(jsonPath("content[0].productPrice").value(1299000.0))
                .andExpect(jsonPath("content[0].productQuantity").value(5))
                .andExpect(jsonPath("content[0].sizeName").value("M"))
                .andExpect(jsonPath("content[4].productId").value(27))
                .andExpect(jsonPath("content[4].productCode").value("A-0005"))
                .andExpect(jsonPath("content[4].productName").value("Áo Sơ Mi Thêu Họa Tiết Nổi"))
                .andExpect(jsonPath("content[4].productPrice").value(1699000.0))
                .andExpect(jsonPath("content[4].productQuantity").value(0))
                .andExpect(jsonPath("content[4].sizeName").value("M"));
    }

    /**
     * LoanTTV
     * this method is used to test for function getAllProducts with input param (sizeName is null)
     * @throws Exception
     */
    @Test
    public void getProductList_sizeName_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list?page=0&size=5&productName=Áo&minPrice=1000000&maxPrice=2000000&sortDirection=desc")
                                .header("Authorization", "Bearer " + TOKEN_VALID))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(3))
                .andExpect(jsonPath("totalElements").value(13))
                .andExpect(jsonPath("content[0].productId").value(17))
                .andExpect(jsonPath("content[0].productCode").value("A-0001"))
                .andExpect(jsonPath("content[0].productName").value("Áo Sơ Mi Vải Poplin"))
                .andExpect(jsonPath("content[0].productPrice").value(1299000.0))
                .andExpect(jsonPath("content[0].productQuantity").value(5))
                .andExpect(jsonPath("content[0].sizeName").value("M"))
                .andExpect(jsonPath("content[4].productId").value(17))
                .andExpect(jsonPath("content[4].productCode").value("A-0001"))
                .andExpect(jsonPath("content[4].productName").value("Áo Sơ Mi Vải Poplin"))
                .andExpect(jsonPath("content[4].productPrice").value(1299000.0))
                .andExpect(jsonPath("content[4].productQuantity").value(0))
                .andExpect(jsonPath("content[4].sizeName").value(" S"));
    }

    /**
     * LoanTTV
     * this method is used to test for function getAllProducts with input param (sizeName is empty)
     * @throws Exception
     */
    @Test
    public void getProductList_sizeName_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list?page=0&size=5&productName=Áo&minPrice=1000000&maxPrice=2000000&sizeName=&sortDirection=desc")
                                .header("Authorization", "Bearer " + TOKEN_VALID))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(3))
                .andExpect(jsonPath("totalElements").value(13))
                .andExpect(jsonPath("content[0].productId").value(17))
                .andExpect(jsonPath("content[0].productCode").value("A-0001"))
                .andExpect(jsonPath("content[0].productName").value("Áo Sơ Mi Vải Poplin"))
                .andExpect(jsonPath("content[0].productPrice").value(1299000.0))
                .andExpect(jsonPath("content[0].productQuantity").value(5))
                .andExpect(jsonPath("content[0].sizeName").value("M"))
                .andExpect(jsonPath("content[4].productId").value(17))
                .andExpect(jsonPath("content[4].productCode").value("A-0001"))
                .andExpect(jsonPath("content[4].productName").value("Áo Sơ Mi Vải Poplin"))
                .andExpect(jsonPath("content[4].productPrice").value(1299000.0))
                .andExpect(jsonPath("content[4].productQuantity").value(0))
                .andExpect(jsonPath("content[4].sizeName").value(" S"));
    }

    /**
     * LoanTTV
     * this method is used to test for function getAllProducts with input param (sizeName is not existed)
     * @throws Exception
     */
    @Test
    public void getProductList_sizeName_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list?page=0&size=5&productName=Áo&minPrice=1000000&maxPrice=2000000&sizeName=XXXL&sortDirection=desc")
                                .header("Authorization", "Bearer " + TOKEN_VALID))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * LoanTTV
     * this method is used to test for function getAllProducts with input param (sizeName is existed but list is empty)
     * @throws Exception
     */
    @Test
    public void getProductList_sizeName_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list?page=0&size=5&productName=a&minPrice=500000&maxPrice=1000000&sizeName=%20L&sortDirection=desc")
                                .header("Authorization", "Bearer " + TOKEN_VALID))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * LoanTTV
     * this method is used to test for function getAllProducts with input param (sizeName is existed and list has data)
     * @throws Exception
     */
    @Test
    public void getProductList_sizeName_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list?page=0&size=5&productName=Áo&minPrice=1000000&maxPrice=2000000&sizeName=XS&sortDirection=desc")
                                .header("Authorization", "Bearer " + TOKEN_VALID))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].productId").value(1))
                .andExpect(jsonPath("content[0].productCode").value("A-0001"))
                .andExpect(jsonPath("content[0].productName").value("Áo Sơ Mi Vải Poplin"))
                .andExpect(jsonPath("content[0].productPrice").value(1299000.0))
                .andExpect(jsonPath("content[0].productQuantity").value(1))
                .andExpect(jsonPath("content[0].sizeName").value("XS"));
    }




}
