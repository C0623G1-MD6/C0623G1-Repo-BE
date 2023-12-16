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
public class InvoiceController_getAllCustomer {
    @Autowired
    private MockMvc mockMvc;


    /**
     * The method helps check in case the parameter is null
     *
     * @param page = null
     * @param keyword = null
     * @return page iCustomerDto and 200 Ok
     * @throws Exception
     * @author NhatNk
     * @since 2023-12-14
     */
    @Test
    public void getAllCustomer_page_keyword_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/invoices/customers"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(7))
                .andExpect(jsonPath("totalElements").value(31))
                .andExpect(jsonPath("content[0].name").value("Hoàng Thái Sơn"))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].customer_code").value("KH-0001"))
                .andExpect(jsonPath("content[0].is_deleted").value(false))
                .andExpect(jsonPath("content[0].phone").value("0911111111"))
                .andExpect(jsonPath("content[0].point").value(15992))
                .andExpect(jsonPath("content[0].discount_percent").value(3.0))
                .andExpect(jsonPath("content[4].name").value("Bùi Thanh Quang"))
                .andExpect(jsonPath("content[4].id").value(6))
                .andExpect(jsonPath("content[4].customer_code").value("KH-0006"))
                .andExpect(jsonPath("content[4].is_deleted").value(false))
                .andExpect(jsonPath("content[4].phone").value("0967676767"))
                .andExpect(jsonPath("content[4].point").value("6495"))
                .andExpect(jsonPath("content[4].discount_percent").value(0.0));
    };

    /**
     * The method helps check in case the parameter is empty
     *
     * @param page    = ""
     * @param keyword = ""
     * @return page iCustomerDto and 200 Ok
     * @throws Exception
     * @author NhatNk
     * @since 2023-12-14
     */
    @Test
    public void getAllCustomer_page_keyword_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/invoices/customers?page=&keyword="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(7))
                .andExpect(jsonPath("totalElements").value(31))
                .andExpect(jsonPath("content[0].name").value("Hoàng Thái Sơn"))
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].customer_code").value("KH-0001"))
                .andExpect(jsonPath("content[0].is_deleted").value(false))
                .andExpect(jsonPath("content[0].phone").value("0911111111"))
                .andExpect(jsonPath("content[0].point").value(15992))
                .andExpect(jsonPath("content[0].discount_percent").value(3.0))
                .andExpect(jsonPath("content[4].name").value("Bùi Thanh Quang"))
                .andExpect(jsonPath("content[4].id").value(6))
                .andExpect(jsonPath("content[4].customer_code").value("KH-0006"))
                .andExpect(jsonPath("content[4].is_deleted").value(false))
                .andExpect(jsonPath("content[4].phone").value("0967676767"))
                .andExpect(jsonPath("content[4].point").value("6495"))
                .andExpect(jsonPath("content[4].discount_percent").value(0.0));
    }


    /**
     * The method helps check in case the parameter do not exist in the database
     *
     * @param page    = 0
     * @param keyword = 0055
     * @return 400 Bad Request
     * @throws Exception
     * @author NhatNk
     * @since 2023-12-14
     */
    @Test
    public void getAllCustomer_page_keyword_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/invoices/customers?page=0&keyword=0055"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * The method helps check in case the parameter exist in the database (page iCustomerDto is empty)
     *
     * @param page    = 0
     * @param keyword = 011
     * @return 400 Bad Request
     * @throws Exception
     * @author NhatNk
     * @since 2023-12-14
     */
    @Test
    public void getAllCustomer_page_keyword_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/invoices/customers?page=0&keyword=011"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * The method helps check in case the parameter exist in the database (page iCustomerDto has data)
     *
     * @param page    = 1
     * @param keyword = th
     * @return 400 Bad Request
     * @throws Exception
     * @author NhatNk
     * @since 2023-12-14
     */
    @Test
    public void getAllCustomer_page_keyword_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/invoices/customers?page=1&keyword=th"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(10))
                .andExpect(jsonPath("content[0].name").value("Nguyễn Thị Thùy Linh"))
                .andExpect(jsonPath("content[0].id").value(21))
                .andExpect(jsonPath("content[0].customer_code").value("KH-0021"))
                .andExpect(jsonPath("content[0].is_deleted").value(false))
                .andExpect(jsonPath("content[0].phone").value("0971616161"))
                .andExpect(jsonPath("content[0].point").value(0))
                .andExpect(jsonPath("content[0].discount_percent").value(0.0))
                .andExpect(jsonPath("content[4].name").value("Chung Thanh Bình"))
                .andExpect(jsonPath("content[4].id").value(31))
                .andExpect(jsonPath("content[4].customer_code").value("KH-0031"))
                .andExpect(jsonPath("content[4].is_deleted").value(false))
                .andExpect(jsonPath("content[4].phone").value("0976245862"))
                .andExpect(jsonPath("content[4].point").value(0))
                .andExpect(jsonPath("content[4].discount_percent").value(0.0));
    }
}
