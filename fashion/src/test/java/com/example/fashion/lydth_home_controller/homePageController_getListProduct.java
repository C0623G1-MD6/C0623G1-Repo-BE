package com.example.fashion.lydth_home_controller;

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
public class homePageController_getListProduct {
    @Autowired
    private MockMvc mockMvc;

    /**
     * @Creator: LyDTH
     * date: 15/12/2023
     * test: get all products
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    /**
     *
     * @throws Exception
     */
    @Test
    public void findAllProducts_7() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products
     * @Param: option
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    void findAllProducts_8() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home").param("option", "")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products
     * @Param: option
     * @Goal: HttpStatus = 204
     * @Throw: Exception
     */
    @Test
    public void findAllProducts_10() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home").param("option", "price")
                ))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products
     * @Goal: HttpStatus = 200
     * @Throw: Exception
     */
    @Test
    void findAllProducts_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                        "/api/home?page=0"
                                ).param("option", "price")
                                .param("sort", "ASC")
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(4))
                .andExpect(jsonPath("totalElements").value(15))
                .andExpect(jsonPath("content[0].percent").value(0.1))
                .andExpect(jsonPath("content[0].productCode").value("A-0003"))
                .andExpect(jsonPath("content[0].productId").value(3))
                .andExpect(jsonPath("content[0].gender").value(true))
                .andExpect(jsonPath("content[0].price").value(799000.0))
                .andExpect(jsonPath("content[0].productName").value("Áo Gi Lê Vải Mềm Dệt Kim"))
                .andExpect(jsonPath("content[0].categoryName").value("Áo"))
                .andExpect(jsonPath("content[3].percent").value(0.05))
                .andExpect(jsonPath("content[3].productCode").value("A-0001"))
                .andExpect(jsonPath("content[3].productId").value(1))
                .andExpect(jsonPath("content[3].gender").value(true))
                .andExpect(jsonPath("content[3].price").value(1299000.0))
                .andExpect(jsonPath("content[3].productName").value("Áo Sơ Mi Vải Poplin"))
                .andExpect(jsonPath("content[3].categoryName").value("Áo"));
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products
     * @Param: sort
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void findAllProducts_9() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home").param("option", "price")
                        .param("sort", "DCSF")
                ))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products has promotion
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void findAllProductsHasPromotion_7() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/promotion")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products has promotion
     * @Param: option
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    void findAllProductsHasPromotion_8() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/promotion").param("option", "")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products has promotion
     * @Param: option
     * @Goal: HttpStatus = 204
     * @Throw: Exception
     */

    @Test
    public void findAllProductsHasPromotion_10() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/promotion").param("option", "price")
                ))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products has promotion
     * @Goal: HttpStatus = 200
     * @Throw: Exception
     */
    @Test
    void findAllProductsHasPromotion_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                        "/api/home/promotion?page=0"
                                ).param("option", "price")
                                .param("sort", "ASC")
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(3))
                .andExpect(jsonPath("totalElements").value(10))
                .andExpect(jsonPath("content[0].percent").value(0.1))
                .andExpect(jsonPath("content[0].productCode").value("A-0003"))
                .andExpect(jsonPath("content[0].productId").value(3))
                .andExpect(jsonPath("content[0].gender").value(true))
                .andExpect(jsonPath("content[0].price").value(799000.0))
                .andExpect(jsonPath("content[0].productName").value("Áo Gi Lê Vải Mềm Dệt Kim"))
                .andExpect(jsonPath("content[0].categoryName").value("Áo"))
                .andExpect(jsonPath("content[3].percent").value(0.05))
                .andExpect(jsonPath("content[3].productCode").value("A-0001"))
                .andExpect(jsonPath("content[3].productId").value(1))
                .andExpect(jsonPath("content[3].gender").value(true))
                .andExpect(jsonPath("content[3].price").value(1299000.0))
                .andExpect(jsonPath("content[3].productName").value("Áo Sơ Mi Vải Poplin"))
                .andExpect(jsonPath("content[3].categoryName").value("Áo"));
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products has promotion
     * @Param: sort
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void findAllProductsHasPromotion_9() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/promotion").param("option", "price")
                        .param("sort", "DCSF")
                ))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products for men
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void findAllProductsForMen_7() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/men")))
                .andDo(print())
                .andExpect(status().isBadRequest());
        /**
         * @Creator: LyDTH
         * @Date: 15/12/2023
         * @Test: get all products for men
         * @Param: option
         * @Goal: HttpStatus = 400
         * @Throw: Exception
         */
    }

    @Test
    void findAllProductsForMen_8() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/men").param("option", "")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products for men
     * @Param: option
     * @Goal: HttpStatus = 204
     * @Throw: Exception
     */

    @Test
    public void findAllProductsForMen_10() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/men").param("option", "price")
                ))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products for men
     * @Goal: HttpStatus = 200
     * @Throw: Exception
     */
    @Test
    void findAllProductsForMen_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                        "/api/home/men?page=0"
                                ).param("option", "price")
                                .param("sort", "ASC")
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(5))
                .andExpect(jsonPath("content[0].percent").value(0.5))
                .andExpect(jsonPath("content[0].productCode").value("PK-0001"))
                .andExpect(jsonPath("content[0].productId").value(15))
                .andExpect(jsonPath("content[0].gender").value(false))
                .andExpect(jsonPath("content[0].price").value(999000.0))
                .andExpect(jsonPath("content[0].productName").value("Thắt Lưng Da"))
                .andExpect(jsonPath("content[0].categoryName").value("Phụ kiện"))
                .andExpect(jsonPath("content[3].percent").value(0.05))
                .andExpect(jsonPath("content[3].productCode").value("BCL-0001"))
                .andExpect(jsonPath("content[3].productId").value(13))
                .andExpect(jsonPath("content[3].gender").value(false))
                .andExpect(jsonPath("content[3].price").value(2999000.0))
                .andExpect(jsonPath("content[3].productName").value("Bộ Suit Vải Dệt"))
                .andExpect(jsonPath("content[3].categoryName").value("Bộ Comple"));
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products for men
     * @Param: sort
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void findAllProductsForMen_9() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/men").param("option", "price")
                        .param("sort", "DCSF")
                ))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products for women
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void findAllProductsForWomen_7() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/women")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products for women
     * @Param: option
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    void findAllProductsForWomen_8() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/women").param("option", "")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products for women
     * @Param: option
     * @Goal: HttpStatus = 204
     * @Throw: Exception
     */

    @Test
    public void findAllProductsForWomen_10() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/women").param("option", "price")
                ))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products for women
     * @Goal: HttpStatus = 200
     * @Throw: Exception
     */
    @Test
    void findAllProductsForWomen_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                        "/api/home/women?page=0"
                                ).param("option", "price")
                                .param("sort", "ASC")
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(3))
                .andExpect(jsonPath("totalElements").value(10))
                .andExpect(jsonPath("content[0].percent").value(0.1))
                .andExpect(jsonPath("content[0].productCode").value("A-0003"))
                .andExpect(jsonPath("content[0].productId").value(3))
                .andExpect(jsonPath("content[0].gender").value(true))
                .andExpect(jsonPath("content[0].price").value(799000.0))
                .andExpect(jsonPath("content[0].productName").value("Áo Gi Lê Vải Mềm Dệt Kim"))
                .andExpect(jsonPath("content[0].categoryName").value("Áo"))
                .andExpect(jsonPath("content[3].percent").value(0.05))
                .andExpect(jsonPath("content[3].productCode").value("A-0002"))
                .andExpect(jsonPath("content[3].productId").value(2))
                .andExpect(jsonPath("content[3].gender").value(true))
                .andExpect(jsonPath("content[3].price").value(2999000.0))
                .andExpect(jsonPath("content[3].productName").value("Áo Sơ Mi Vải Poplin Cổ Đính Đá"))
                .andExpect(jsonPath("content[3].categoryName").value("Áo"));
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products for women
     * @Param: sort
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void findAllProductsForWomen_sort_9() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/women").param("option", "price")
                        .param("sort", "DCSF")
                ))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products by category name
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void findAllProductsByCategory_7() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/category")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products by category name
     * @Param: option
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    void findAllProductsByCategory_option_8() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/category").param("option", "")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products by category name
     * @Param: option
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */

    @Test
    public void findAllProductsByCategory_option_10() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/category").param("option", "price")
                ))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products by category name
     * @Param: categoryName
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    void findAllProductsByCategory_categoryName_8() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/category").param("categoryName", "")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products by category name
     * @Param: categoryName
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void findAllProductsByCategory_categoryName_10() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/category").param("categoryName", "Ao")
                ))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products by category name
     * @Param: categoryName
     * @Goal: HttpStatus = 200
     * @Throw: Exception
     */
    @Test
    void findAllProductsByCategory_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                        "/api/home/category?page=0"
                                ).param("option", "price")
                                .param("sort", "ASC")
                                .param("categoryName", "Áo")
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(5))
                .andExpect(jsonPath("content[0].percent").value(0.1))
                .andExpect(jsonPath("content[0].productCode").value("A-0003"))
                .andExpect(jsonPath("content[0].productId").value(3))
                .andExpect(jsonPath("content[0].gender").value(true))
                .andExpect(jsonPath("content[0].price").value(799000.0))
                .andExpect(jsonPath("content[0].productName").value("Áo Gi Lê Vải Mềm Dệt Kim"))
                .andExpect(jsonPath("content[0].categoryName").value("Áo"))
                .andExpect(jsonPath("content[3].percent").value(0.0))
                .andExpect(jsonPath("content[3].productCode").value("A-0006"))
                .andExpect(jsonPath("content[3].productId").value(12))
                .andExpect(jsonPath("content[3].gender").value(false))
                .andExpect(jsonPath("content[3].price").value(1299000.0))
                .andExpect(jsonPath("content[3].productName").value("Áo Sơ Mi Vải Lyocell Có Túi"))
                .andExpect(jsonPath("content[3].categoryName").value("Áo"));
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products by category name
     * @Param: sort
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void findAllProductsByCategory_sort_9() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/category").param("option", "price")
                        .param("sort", "DCSF")
                ))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products by category name
     * @Param: option
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void findAllProductsByCategory_option_9() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/category").param("option", "pradfice")
                ))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products by category name
     * @Param: categoryName
     * @Goal: HttpStatus = 204
     * @Throw: Exception
     */
    @Test
    public void findAllProductsByCategory_categoryName_9() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/category").param("option", "price")
                        .param("sort", "ASC")
                        .param("categoryName", "adafd")
                ))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products by product name
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void findAllProductsByName_7() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/productName")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products by product name
     * @Param: option
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    void findAllProductsByName_option_8() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/productName").param("option", "")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products by product name
     * @Param: option
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */

    @Test
    public void findAllProductsByName_option_10() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/productName").param("option", "price")
                ))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products by product name
     * @Param: productName
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    void findAllProductsByName_productName_8() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/productName").param("productName", "")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products by product name
     * @Param: productName
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */

    @Test
    public void findAllProductsByName_productName_10() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/productName").param("productName", "Ao")
                ))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products by product name
     * @Goal: HttpStatus = 200
     * @Throw: Exception
     */
    @Test
    void findAllProductsByName_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                        "/api/home/productName?page=0"
                                ).param("option", "price")
                                .param("sort", "ASC")
                                .param("productName", "Áo")
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].percent").value(0.1))
                .andExpect(jsonPath("content[0].productCode").value("A-0003"))
                .andExpect(jsonPath("content[0].productId").value(3))
                .andExpect(jsonPath("content[0].gender").value(true))
                .andExpect(jsonPath("content[0].price").value(799000.0))
                .andExpect(jsonPath("content[0].productName").value("Áo Gi Lê Vải Mềm Dệt Kim"))
                .andExpect(jsonPath("content[0].categoryName").value("Áo"))
                .andExpect(jsonPath("content[3].percent").value(0.0))
                .andExpect(jsonPath("content[3].productCode").value("A-0006"))
                .andExpect(jsonPath("content[3].productId").value(12))
                .andExpect(jsonPath("content[3].gender").value(false))
                .andExpect(jsonPath("content[3].price").value(1299000.0))
                .andExpect(jsonPath("content[3].productName").value("Áo Sơ Mi Vải Lyocell Có Túi"))
                .andExpect(jsonPath("content[3].categoryName").value("Áo"));
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products by product name
     * @Param: sort
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void findAllProductsByName_sort_9() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/productName").param("option", "price")
                        .param("sort", "DCSF")
                ))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products by product name
     * @Param: option
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void findAllProductsByName_option_9() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/productName").param("option", "pradfice")
                ))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * @Creator: LyDTH
     * @Date: 15/12/2023
     * @Test: get all products by product name
     * @Param: productName
     * @Goal: HttpStatus = 204
     * @Throw: Exception
     */
    @Test
    public void findAllProductsByName_productName_9() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home/productName").param("option", "price")
                        .param("sort", "ASC")
                        .param("productName", "adafd")
                ))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}
