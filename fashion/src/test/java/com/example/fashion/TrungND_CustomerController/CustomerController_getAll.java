package com.example.fashion.TrungND_CustomerController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerController_getAll {

    @Autowired
    private MockMvc mockMvc;

    /**
     * create by TrungND
     * date 14-12-2023
     * goal: get List customer with parameter equal null
     * return HttpStatus 4xx
     */
    @Test
    public void getListCustomer_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/customer/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by TrungND
     * date 14-12-2023
     * goal: get List customer with parameter equal ""
     * return HttpStatus 2xx
     */

    @Test
    public void getListCustomer_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/customer?nameCustomer=&typeCustomer=&page="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(4))
                .andExpect(jsonPath("totalElements").value(20))
                .andExpect(jsonPath("content[0].name").value("Nguyễn Thị Thảo"))
                .andExpect(jsonPath("content[0].customerCode").value("KH-001"))
                .andExpect(jsonPath("content[0].birthday").value("1990-01-15"))
                .andExpect(jsonPath("content[0].gender").value(true))
                .andExpect(jsonPath("content[0].phone").value("0123456789"))
                .andExpect(jsonPath("content[0].email").value("nguyenthaothao@gmail.com"))
                .andExpect(jsonPath("content[0].address").value("123 Đường ABC, Quận 1, TP.HCM"))
                .andExpect(jsonPath("content[0].point").value("100"))
                .andExpect(jsonPath("content[0].customerType.id").value("1"))
                .andExpect(jsonPath("content[0].deleted").value(false));

    }
    /**
     * create by TrungND
     * date 14-12-2023
     * goal: get List customer with parameter idType is out of bound
     * return HttpStatus 2xx
     */
    @Test
    public void getListCustomer_9() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/customer?nameCustomer=&typeCustomer=abc&page="))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    /**
     * create by TrungND
     * date 14-12-2023
     * goal: get List customer with parameter idType has value in of bound but listSize = 0
     * return HttpStatus 2xx
     */

    @Test
    public void getListCustomer_10() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/customer?nameCustomer=W&typeCustomer=member&page="))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    /**
     * create by TrungND
     * date 14-12-2023
     * goal: get List customer with parameter idType has value in of bound and listSize > 0
     * return HttpStatus 2xx
     */
    @Test
    public void getListCustomer_11() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/customer?nameCustomer=T&typeCustomer=member&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].name").value("Nguyễn Thị Thảo"))
                .andExpect(jsonPath("content[0].customerCode").value("KH-001"))
                .andExpect(jsonPath("content[0].birthday").value("1990-01-15"))
                .andExpect(jsonPath("content[0].gender").value(true))
                .andExpect(jsonPath("content[0].phone").value("0123456789"))
                .andExpect(jsonPath("content[0].email").value("nguyenthaothao@gmail.com"))
                .andExpect(jsonPath("content[0].address").value("123 Đường ABC, Quận 1, TP.HCM"))
                .andExpect(jsonPath("content[0].point").value("100"))
                .andExpect(jsonPath("content[0].customerType.id").value("1"))
                .andExpect(jsonPath("content[0].deleted").value(false))
                .andExpect(jsonPath("content[4].name").value("Trần Văn Lợi"))
                .andExpect(jsonPath("content[4].customerCode").value("KH-011"))
                .andExpect(jsonPath("content[4].birthday").value("1984-10-04"))
                .andExpect(jsonPath("content[4].gender").value(true))
                .andExpect(jsonPath("content[4].phone").value("0123456789"))
                .andExpect(jsonPath("content[4].email").value("tranvanloi@gmail.com"))
                .andExpect(jsonPath("content[4].address").value("808 Đường LMN, Quận 11, TP.HCM"))
                .andExpect(jsonPath("content[4].point").value("140"))
                .andExpect(jsonPath("content[4].customerType.id").value("1"))
                .andExpect(jsonPath("content[4].deleted").value(false));
    }
}
