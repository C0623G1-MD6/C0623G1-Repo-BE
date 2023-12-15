package com.example.fashion.nhatnk_controller;

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
public class InvoiceController_getListProduct {
    @Autowired
    private MockMvc mockMvc;


    /**
     * The method helps check in case the parameter is null
     *
     * @param keyword = null
     * @return list iProductDto and 200 Ok
     * @throws Exception
     * @author NhatNk
     * @since 2023-12-14
     */
    @Test
    public void getListProduct_keyword_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/invoices/products"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].name").value("Áo Sơ Mi Vải Poplin"))
                .andExpect(jsonPath("$[0].percent").value(0.05))
                .andExpect(jsonPath("$[0].product_code").value("A-0001"))
                .andExpect(jsonPath("$[0].price").value(1299000.0))
                .andExpect(jsonPath("$[9].name").value("Áo Khóa Len Lông Thú"))
                .andExpect(jsonPath("$[9].percent").value(0.2))
                .andExpect(jsonPath("$[9].product_code").value("AK-0001"))
                .andExpect(jsonPath("$[9].price").value(3999000.0));
    }


    /**
     * The method helps check in case the parameter is null
     *
     * @param keyword = ""
     * @return list iProductDto and 200 Ok
     * @throws Exception
     * @author NhatNk
     * @since 2023-12-14
     */
    @Test
    public void getListProduct_keyword_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/invoices/products?keyword="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].name").value("Áo Sơ Mi Vải Poplin"))
                .andExpect(jsonPath("$[0].percent").value(0.05))
                .andExpect(jsonPath("$[0].product_code").value("A-0001"))
                .andExpect(jsonPath("$[0].price").value(1299000.0))
                .andExpect(jsonPath("$[9].name").value("Áo Khóa Len Lông Thú"))
                .andExpect(jsonPath("$[9].percent").value(0.2))
                .andExpect(jsonPath("$[9].product_code").value("AK-0001"))
                .andExpect(jsonPath("$[9].price").value(3999000.0));
    }

    /**
     * The method helps check in case the parameter do not exist in the database
     *
     * @param keyword = dqfffa
     * @return list iProductDto and 200 Ok
     * @throws Exception
     * @author NhatNk
     * @since 2023-12-14
     */
    @Test
    public void getListProduct_keyword_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/invoices/products?keyword=dqfffa"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * The method helps check in case the parameter exist in the database (page iCustomerDto has data)
     *
     * @param keyword = Ao So
     * @return list iProductDto and 200 Ok
     * @throws Exception
     * @author NhatNk
     * @since 2023-12-14
     */
    @Test
    public void getListProduct_keyword_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/invoices/products?keyword=Ao So"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].name").value("Áo Sơ Mi Vải Poplin"))
                .andExpect(jsonPath("$[0].percent").value(0.05))
                .andExpect(jsonPath("$[0].product_code").value("A-0001"))
                .andExpect(jsonPath("$[0].price").value(1299000.0))
                .andExpect(jsonPath("$[3].name").value("Áo Sơ Mi Vải Lyocell Có Túi"))
                .andExpect(jsonPath("$[3].percent").value(0.0))
                .andExpect(jsonPath("$[3].product_code").value("A-0006"))
                .andExpect(jsonPath("$[3].price").value(1299000.0));
    }
}
