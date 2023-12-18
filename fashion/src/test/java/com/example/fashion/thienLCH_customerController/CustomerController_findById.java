package com.example.fashion.thienLCH_customerController;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class CustomerController_findById {
    @Autowired
    MockMvc mockMvc;
    private ObjectMapper objectMapper;

    /**
     * create by ThienLCH ok
     * date 13-12-2023
     * goal: get customer with id equal 2
     * return HttpStatus 2xx
     */
    @Test
    public void get_customer_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/customer/{id}", "2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * create by ThienLCH ok
     * date 13-12-2023
     * goal: get customer with id equal ""
     * return HttpStatus 4xx
     */
    @Test
    public void get_customer_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/customer/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by ThienLCH ok
     * date 13-12-2023
     * goal: get customer with id equal null
     * return HttpStatus 4xx
     */
    @Test
    public void get_customer_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                .get("/api/customer"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by ThienLCH
     * date 13-12-2023
     * goal: get customer with id is out of bound
     * return HttpStatus 4xx
     */
    @Test
    public void get_customer_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                .get("/api/customer/{id}","100"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}
