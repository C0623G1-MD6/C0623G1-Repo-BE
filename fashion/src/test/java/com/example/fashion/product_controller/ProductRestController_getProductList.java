package com.example.fashion.product_controller;

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
     * Empty List
     * @throws Exception
     */
    @Test
    public void getProductList_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/product/list"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

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
                .andExpect(jsonPath("content[4].productId").value(21))
                .andExpect(jsonPath("content[4].productCode").value("Q-0001"))
                .andExpect(jsonPath("content[4].productName").value("Quần Cargo Có Túi Cài Khóa Kéo"))
                .andExpect(jsonPath("content[4].productPrice").value(1999000.0))
                .andExpect(jsonPath("content[4].productQuantity").value(0))
                .andExpect(jsonPath("content[4].sizeName").value("M"));
    }

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
                .andExpect(jsonPath("content[4].productId").value(21))
                .andExpect(jsonPath("content[4].productCode").value("Q-0001"))
                .andExpect(jsonPath("content[4].productName").value("Quần Cargo Có Túi Cài Khóa Kéo"))
                .andExpect(jsonPath("content[4].productPrice").value(1999000.0))
                .andExpect(jsonPath("content[4].productQuantity").value(0))
                .andExpect(jsonPath("content[4].sizeName").value("M"));
    }

    @Test
    public void getProductList_productName_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list?page=0&size=5&productName=a@&minPrice=1000000&maxPrice=2000000&sizeName=M&sortDirection=desc")
                                .header("Authorization", "Bearer " + TOKEN_VALID))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getProductList_productName_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list?page=0&size=5&productName=a&minPrice=500000&maxPrice=1000000&sizeName=XL&sortDirection=desc")
                                .header("Authorization", "Bearer " + TOKEN_VALID))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

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
                .andExpect(jsonPath("content[4].productId").value(28))
                .andExpect(jsonPath("content[4].productCode").value("A-0006"))
                .andExpect(jsonPath("content[4].productName").value("Áo Sơ Mi Vải Lyocell Có Túi"))
                .andExpect(jsonPath("content[4].productPrice").value(1299000.0))
                .andExpect(jsonPath("content[4].productQuantity").value(0))
                .andExpect(jsonPath("content[4].sizeName").value("M"));
    }

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
                .andExpect(jsonPath("content[4].productId").value(27))
                .andExpect(jsonPath("content[4].productCode").value("A-0005"))
                .andExpect(jsonPath("content[4].productName").value("Áo Sơ Mi Thêu Họa Tiết Nổi"))
                .andExpect(jsonPath("content[4].productPrice").value(1699000.0))
                .andExpect(jsonPath("content[4].productQuantity").value(0))
                .andExpect(jsonPath("content[4].sizeName").value("M"));
    }

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
                .andExpect(jsonPath("content[4].productId").value(27))
                .andExpect(jsonPath("content[4].productCode").value("A-0005"))
                .andExpect(jsonPath("content[4].productName").value("Áo Sơ Mi Thêu Họa Tiết Nổi"))
                .andExpect(jsonPath("content[4].productPrice").value(1699000.0))
                .andExpect(jsonPath("content[4].productQuantity").value(0))
                .andExpect(jsonPath("content[4].sizeName").value("M"));
    }

    @Test
    public void getProductList_minPrice_maxPrice_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list?page=0&size=5&productName=Áo&minPrice=5000000&maxPrice=10000000&sizeName=M&sortDirection=desc")
                                .header("Authorization", "Bearer " + TOKEN_VALID))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getProductList_minPrice_maxPrice_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product/list?page=0&size=5&productName=Áo&minPrice=500000&maxPrice=1000000&sizeName=XS&sortDirection=desc")
                                .header("Authorization", "Bearer " + TOKEN_VALID))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

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
                .andExpect(jsonPath("content[4].productId").value(28))
                .andExpect(jsonPath("content[4].productCode").value("A-0006"))
                .andExpect(jsonPath("content[4].productName").value("Áo Sơ Mi Vải Lyocell Có Túi"))
                .andExpect(jsonPath("content[4].productPrice").value(1299000.0))
                .andExpect(jsonPath("content[4].productQuantity").value(0))
                .andExpect(jsonPath("content[4].sizeName").value("M"));
    }

}
