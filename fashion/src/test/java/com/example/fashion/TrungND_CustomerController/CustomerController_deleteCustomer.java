package com.example.fashion.TrungND_CustomerController;

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
public class CustomerController_deleteCustomer {
    @Autowired
    private MockMvc mockMvc;

    /**
     * create by TrungND
     * date 14-12-2023
     * goal: deleteCustomer with parameter is null
     * return HttpStatus 4xx
     */

    @Test
    public void deleteCustomer_id_25() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/customer/delete"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * create by TrungND
     * date 14-12-2023
     * goal: deleteCustomer with parameter equal ""
     * return HttpStatus 4xx
     */
    @Test
    public void deleteCustomer_id_26() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/customer/delete/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * create by TrungND
     * date 14-12-2023
     * goal: deleteCustomer with parameter is out of bound
     * return HttpStatus 4xx
     */
    @Test
    public void deleteCustomer_id_27() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/customer/delete/{id}","100"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * create by TrungND
     * date 14-12-2023
     * goal: delete customer with parameter is in of bound
     * return HttpStatus 2xx
     */
    @Test
    public void deleteCustomer_id_28() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/customer/delete/{id}","6"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
