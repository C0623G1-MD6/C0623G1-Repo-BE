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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthController_getInfoEmployeeByIdAccount {

    private static final String TOKEN_VALID = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbjEyMyIsImlhdCI6MTcwMjUyMzcxMCwiZXhwIjoxNzg4OTIzNzEwfQ.dMI9BADFNcu5fjXUuD4O804bNLtYAkS0J6hp7Es0gEo";
    @Autowired
    private MockMvc mockMvc;

    /**
     * @Creator: ThanhPV
     * @parameter id equals null
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void getInformation_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/employee/{id}", 1))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
