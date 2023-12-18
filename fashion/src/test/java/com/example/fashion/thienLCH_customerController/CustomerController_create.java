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
public class CustomerController_create {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * create by ThienLCH ok
     * date 13-12-2023
     * goal: create customer with customer equal null
     * return HttpStatus 4xx
     */
    @Test
    public void create_customer_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/customer/create")
                                .content(this.objectMapper.writeValueAsString(null))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by ThienLCH ok
     * date 13-12-2023
     * goal: create customer with customer equal ""
     * return HttpStatus 4xx
     */
    @Test
    public void create_customer_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/customer/create")
                                .content(this.objectMapper.writeValueAsString(""))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by ThienLCH ok
     * date 13-12-2023
     * goal: create customer with wrong format customer's code
     * return HttpStatus 4xx
     */
    @Test
    public void create_customer_15() throws Exception {
        CustomerDto customerDto = new CustomerDto();
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
                                .post("/api/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by ThienLCH ok
     * date 13-12-2023
     * goal: create customer with wrong format customer's email
     * return HttpStatus 4xx
     */
    @Test
    public void create_customer_15_2() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerCode("KH-030");
        customerDto.setName("Hoan Thien");
        customerDto.setGender(true);
        customerDto.setBirthday("1990-01-21");
        customerDto.setAddress("Ha Noi");
        customerDto.setEmail("thien");
        customerDto.setPhone("012312312");
        customerDto.setDeleted(true);
        customerDto.setCustomerTypeId(1);

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by ThienLCH ok
     * date 13-12-2023
     * goal: create customer with wrong format customer's phone
     * return HttpStatus 4xx
     */
    @Test
    public void create_customer_15_3() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerCode("KH-030");
        customerDto.setName("Hoan Thien");
        customerDto.setGender(true);
        customerDto.setBirthday("1990-01-21");
        customerDto.setAddress("Ha Noi");
        customerDto.setEmail("thien@gmail.com");
        customerDto.setPhone("0123123121");
        customerDto.setDeleted(true);
        customerDto.setCustomerTypeId(1);

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by ThienLCH ok
     * date 13-12-2023
     * goal: create customer with wrong customer's name equal ""
     * return HttpStatus 4xx
     */
    @Test
    public void create_customer_16() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerCode("KH-030");
        customerDto.setName("");
        customerDto.setGender(true);
        customerDto.setBirthday("1990-01-21");
        customerDto.setAddress("Ha Noi");
        customerDto.setEmail("thien@gmail.com");
        customerDto.setPhone("0123123121");
        customerDto.setDeleted(true);
        customerDto.setCustomerTypeId(1);

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by ThienLCH ok
     * date 13-12-2023
     * goal: create customer with wrong customer's name is too long
     * return HttpStatus 4xx
     */
    @Test
    public void create_customer_17() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerCode("KH-030");
        customerDto.setName("content(this.objectMapper.writeValueAsString(customerDto))content(this.objectMapper.writeValueAsString(customerDto))content(this.objectMapper.writeValueAsString(customerDto))content(this.objectMapper.writeValueAsString(customerDto))content(this.objectMapper.writeValueAsString(customerDto))content(this.objectMapper.writeValueAsString(customerDto))content(this.objectMapper.writeValueAsString(customerDto))content(this.objectMapper.writeValueAsString(customerDto))content(this.objectMapper.writeValueAsString(customerDto))content(this.objectMapper.writeValueAsString(customerDto))content(this.objectMapper.writeValueAsString(customerDto))content(this.objectMapper.writeValueAsString(customerDto))");
        customerDto.setGender(true);
        customerDto.setBirthday("1990-01-21");
        customerDto.setAddress("Ha Noi");
        customerDto.setEmail("thien@gmail.com");
        customerDto.setPhone("01231231211");
        customerDto.setDeleted(true);
        customerDto.setCustomerTypeId(1);

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by ThienLCH ok
     * date 13-12-2023
     * goal: create customer with available customer
     * return HttpStatus 2xx
     */
    @Test
    public void create_customer_18() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerCode("KH-030");
        customerDto.setName("Thien Le");
        customerDto.setGender(true);
        customerDto.setBirthday("1990-01-21");
        customerDto.setAddress("Ha Noi");
        customerDto.setEmail("thien@gmail.com");
        customerDto.setPhone("0123123111");
        customerDto.setDeleted(true);
        customerDto.setCustomerTypeId(1);

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/customer/create")
                                .content(this.objectMapper.writeValueAsString(customerDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
