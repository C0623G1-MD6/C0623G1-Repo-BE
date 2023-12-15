package com.example.fashion.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SalesReportController_getSalesReport {
    @Autowired
    private MockMvc mockMvc;
    /**
     * displays a list of sales reports with complete parameters
     * @author:  : LamTV
     * @date: 14-12-2023
     */
    @Test
    public void getSalesReport_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/sales-report/statistical")
                        .param("startDate", "2023-12-01")
                        .param("endDate", "2023-12-15"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * show a list of sales reports with empty parameters
     * @author:  : LamTV
     * @date: 14-12-2023
     */
    @Test
    public void getSalesReport_endDate_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/sales-report/statistical")
                .param("endDate", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * show a list of sales reports with empty parameters
     * @author:  : LamTV
     * @date: 14-12-2023
     */

    @Test
    public void getSalesReport_startDate_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/sales-report/statistical")
                        .param("startDate", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * show a list of sales reports with null parameters
     * @author:  : LamTV
     * @date: 14-12-2023
     */

    @Test
    public void getSalesReport_endDate_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/sales-report/statistical")
                        .param("endDate", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * show a list of sales reports with null parameters
     * @author:  : LamTV
     * @date: 14-12-2023
     */

    @Test
    public void getSalesReport_startDate_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/sales-report/statistical")
                        .param("startDate", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
