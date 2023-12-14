package com.example.fashion.controller;

import com.example.fashion.dto.warehouse.WarehouseDetailDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WarehouseController_saveWarehouse {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    /**
     * Cannot get the value of receipt code
     * @author:  : LamTV
     * @date: 14-12-2023
     */
    @Test
    public void saveWarehouse_receiptCode_13() throws Exception {
        WarehouseDetailDTO warehouseDetailDTO = new WarehouseDetailDTO();
        warehouseDetailDTO.setReceiptCode("null");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/warehouse/inputWarehouse")
                                .content(this.objectMapper.writeValueAsString("null"))
                                .content(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Cannot get the value of receipt date
     * @author:  : LamTV
     * @date: 14-12-2023
     */

    @Test
    public void saveWarehouse_receiptDate_13() throws Exception {
        WarehouseDetailDTO warehouseDetailDTO = new WarehouseDetailDTO();
        warehouseDetailDTO.setReceiptDate(null);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/warehouse/inputWarehouse")
                                .content(this.objectMapper.writeValueAsString(null))
                                .content(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
