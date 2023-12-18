package com.example.fashion.lamtv_controller;

import com.example.fashion.dto.warehouse.WarehouseReceiptDetailDto;
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
     * @method : saveWarehouse_sizeDetailId_13()
     * @author: : LamTV
     * @date: 14-12-2023
     */
    @Test
    public void saveWarehouse_sizeDetailId_13() throws Exception {
        WarehouseReceiptDetailDto warehouseReceiptDetailDto = new WarehouseReceiptDetailDto();
        warehouseReceiptDetailDto.setSizeDetailId(null);
        warehouseReceiptDetailDto.setInputPrice(50000.0);
        warehouseReceiptDetailDto.setInputQuantity(5);
        warehouseReceiptDetailDto.setWarehouseId(21);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/warehouses/inputWarehouseDetail")
                                .content(this.objectMapper.writeValueAsString(warehouseReceiptDetailDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @method : saveWarehouse_inputPrice_13()
     * @author: : LamTV
     * @date: 14-12-2023
     */
    @Test
    public void saveWarehouse_inputPrice_13() throws Exception {
        WarehouseReceiptDetailDto warehouseReceiptDetailDto = new WarehouseReceiptDetailDto();
        warehouseReceiptDetailDto.setInputPrice(null);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/warehouses/inputWarehouseDetail")
                                .content(this.objectMapper.writeValueAsString(warehouseReceiptDetailDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @method : saveWarehouse_inputQuantity_13()
     * @author: : LamTV
     * @date: 14-12-2023
     */
    @Test
    public void saveWarehouse_inputQuantity_13() throws Exception {
        WarehouseReceiptDetailDto warehouseReceiptDetailDto = new WarehouseReceiptDetailDto();
        warehouseReceiptDetailDto.setSizeDetailId(1);
        warehouseReceiptDetailDto.setInputPrice(500000.0);
        warehouseReceiptDetailDto.setInputQuantity(null);
        warehouseReceiptDetailDto.setWarehouseId(21);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/warehouses/inputWarehouseDetail")
                                .content(this.objectMapper.writeValueAsString(warehouseReceiptDetailDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @method : saveWarehouse_inputQuantity_13()
     * @author: : LamTV
     * @date: 14-12-2023
     */
    @Test
    public void saveWarehouse_warehouseId_13() throws Exception {
        WarehouseReceiptDetailDto warehouseReceiptDetailDto = new WarehouseReceiptDetailDto();
        warehouseReceiptDetailDto.setWarehouseId(null);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/warehouses/inputWarehouseDetail")
                                .content(this.objectMapper.writeValueAsString(warehouseReceiptDetailDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @method : saveWarehouse_inputQuantity_16()
     * @author: : LamTV
     * @date: 16-12-2023
     */
    @Test
    public void saveWarehouse_inputQuantity_16() throws Exception {
        WarehouseReceiptDetailDto warehouseReceiptDetailDto = new WarehouseReceiptDetailDto();
        warehouseReceiptDetailDto.setSizeDetailId(1);
        warehouseReceiptDetailDto.setInputPrice(500000.0);
        warehouseReceiptDetailDto.setInputQuantity(2001);
        warehouseReceiptDetailDto.setWarehouseId(21);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/warehouses/inputWarehouseDetail")
                                .content(this.objectMapper.writeValueAsString(warehouseReceiptDetailDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @method : saveWarehouse_inputQuantity_16()
     * @author: : LamTV
     * @date: 16-12-2023
     */
    @Test
    public void saveWarehouse_inputQuantity_17() throws Exception {
        WarehouseReceiptDetailDto warehouseReceiptDetailDto = new WarehouseReceiptDetailDto();
        warehouseReceiptDetailDto.setSizeDetailId(1);
        warehouseReceiptDetailDto.setInputPrice(500000.0);
        warehouseReceiptDetailDto.setInputQuantity(-1);
        warehouseReceiptDetailDto.setWarehouseId(21);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/warehouses/inputWarehouseDetail")
                                .content(this.objectMapper.writeValueAsString(warehouseReceiptDetailDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @method : saveWarehouse_inputPrice_16()
     * @author: : LamTV
     * @date: 14-12-2023
     */
    @Test
    public void saveWarehouse_inputPrice_16() throws Exception {
        WarehouseReceiptDetailDto warehouseReceiptDetailDto = new WarehouseReceiptDetailDto();
        warehouseReceiptDetailDto.setSizeDetailId(1);
        warehouseReceiptDetailDto.setInputPrice(1000000000000000.0);
        warehouseReceiptDetailDto.setInputQuantity(5);
        warehouseReceiptDetailDto.setWarehouseId(21);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/warehouses/inputWarehouseDetail")
                                .content(this.objectMapper.writeValueAsString(warehouseReceiptDetailDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @method : saveWarehouse_inputPrice_17()
     * @author: : LamTV
     * @date: 14-12-2023
     */
    @Test
    public void saveWarehouse_inputPrice_17() throws Exception {
        WarehouseReceiptDetailDto warehouseReceiptDetailDto = new WarehouseReceiptDetailDto();
        warehouseReceiptDetailDto.setSizeDetailId(1);
        warehouseReceiptDetailDto.setInputPrice(-1.0);
        warehouseReceiptDetailDto.setInputQuantity(5);
        warehouseReceiptDetailDto.setWarehouseId(21);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/warehouses/inputWarehouseDetail")
                                .content(this.objectMapper.writeValueAsString(warehouseReceiptDetailDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @method : saveWarehouse_18()
     * @author: : LamTV
     * @date: 14-12-2023
     * success
     */

    @Test
    public void saveWarehouse_18() throws Exception {
        WarehouseReceiptDetailDto warehouseReceiptDetailDto = new WarehouseReceiptDetailDto();
        warehouseReceiptDetailDto.setSizeDetailId(1);
        warehouseReceiptDetailDto.setInputPrice(500000.0);
        warehouseReceiptDetailDto.setInputQuantity(10);
        warehouseReceiptDetailDto.setWarehouseId(25);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/warehouses/inputWarehouseDetail")
                                .content(this.objectMapper.writeValueAsString(warehouseReceiptDetailDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
