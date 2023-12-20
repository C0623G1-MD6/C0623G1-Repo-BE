package com.example.fashion.lamtv_controller;

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
public class WarehouseController_getAllProducts {
    @Autowired
    private MockMvc mockMvc;

    /**
     * show a list product success
     *
     * @author: : LamTV
     * @date: 16-12-2023
     */

    @Test
    public void getSalesReport_getAllProduct_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/warehouses/products"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
