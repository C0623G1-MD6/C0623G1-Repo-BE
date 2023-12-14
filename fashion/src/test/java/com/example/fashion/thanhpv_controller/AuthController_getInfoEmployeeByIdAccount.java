package com.example.fashion.thanhpv_controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthController_getInfoEmployeeByIdAccount {

    // Token ID Account = 3
    private static final String TOKEN_VALID = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbjEyMyIsImlhdCI6MTcwMjUyNjk3MSwiZXhwIjoxNzg4OTI2OTcxfQ.pb1FYC6LubV1HTNmiub3_cljHaKG4KmVV3AHGxRtZnM";
    @Autowired
    private MockMvc mockMvc;

    /**
     * The token is invalid
     * @Creator: ThanhPV
     * @parameter id exists in DB
     * @Goal: HttpStatus = 403
     * @Throw: Exception
     */
    @Test
    public void getInformation_99() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/{id}", 3)
                                .header("Authorization", "Bearer " +""))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    /**
     * The token is valid, the id in the token does not match the id to be obtained
     * @Creator: ThanhPV
     * @parameter id exists in DB
     * @Goal: HttpStatus = 401
     * @Throw: Exception
     */
    @Test
    public void getInformation_98() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/{id}", 2)
                                .header("Authorization", "Bearer " +TOKEN_VALID))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    /**
     * The token is valid
     * @Creator: ThanhPV
     * @parameter id = ""
     * @Goal: HttpStatus = 404
     * @Throw: Exception
     */
    @Test
    public void getInformation_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/{id}", "")
                                .header("Authorization", "Bearer " +TOKEN_VALID))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * The token is valid
     * @Creator: ThanhPV
     * @parameter id does not exist in DB
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void getInformation_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/{id}", 5)
                                .header("Authorization", "Bearer " +TOKEN_VALID))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * The token is valid, the id in the token matches the id to get
     * @Creator: ThanhPV
     * @parameter id exists in DB
     * @Goal: HttpStatus = 2xx
     * @Throw: Exception
     */
    @Test
    public void getInformation_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/{id}", 3)
                                .header("Authorization", "Bearer " +TOKEN_VALID))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(3))
                .andExpect(jsonPath("employeeCode").value("NV003"))
                .andExpect(jsonPath("name").value("Lê Quang C"))
                .andExpect(jsonPath("birthday").value("1988-12-15"))
                .andExpect(jsonPath("email").value("lqc@example.com"))
                .andExpect(jsonPath("address").value("456 Đường DEF, Quận LMN, Thành phố DEF"));
    }

}
