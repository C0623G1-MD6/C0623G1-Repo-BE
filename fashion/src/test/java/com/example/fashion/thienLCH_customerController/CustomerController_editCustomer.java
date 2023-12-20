package com.example.fashion.thienLCH_customerController;

import com.example.fashion.dto.customerDto.CustomerDto;
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
public class CustomerController_editCustomer {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * create by ThienLCH ok
     * date 13-12-2023
     * goal: edit customer with customer equal null
     * return HttpStatus 4xx
     */
    @Test
    public void edit_customer_19() throws Exception {
        CustomerDto customerDto = new CustomerDto();

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/customer/create")
                                .content(this.objectMapper.writeValueAsString(null))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by ThienLCH ok
     * date 13-12-2023
     * goal: edit customer with customer equal ""
     * return HttpStatus 4xx
     */
    @Test
    public void edit_customer_20() throws Exception {
        CustomerDto customerDto = new CustomerDto();

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/customer/create")
                                .content(this.objectMapper.writeValueAsString(""))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by ThienLCH ok
     * date 13-12-2023
     * goal: edit customer with wrong format customer's code
     * return HttpStatus 4xx
     */
    @Test
    public void edit_customer_21_1() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(1);
        customerDto.setCustomerCode("KH-03000");
        customerDto.setName("Hoan Thien");
        customerDto.setGender(true);
        customerDto.setBirthday("1990-01-21");
        customerDto.setAddress("Ha Noi");
        customerDto.setEmail("thien@gmail.com");
        customerDto.setPhone("012312312");
        customerDto.setDeleted(true);
        customerDto.setCustomerTypeId(1);

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by ThienLCH ok
     * date 13-12-2023
     * goal: edit customer with  customer
     * return HttpStatus 2xx
     */
    @Test
    public void edit_customer_23() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(1);
        customerDto.setCustomerCode("KH-030");
        customerDto.setName("Hoan Thiennn");
        customerDto.setGender(true);
        customerDto.setBirthday("1990-01-21");
        customerDto.setAddress("Ha Noi");
        customerDto.setEmail("thien@gmail.com");
        customerDto.setPhone("012312312");
        customerDto.setDeleted(true);
        customerDto.setCustomerTypeId(1);

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
