package com.example.fashion.TruongNQ_controller;

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
public class OverviewController_getTotalRevenue {
    @Autowired
    private MockMvc mockMvc;

    private final String TOKEN_VALID = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbjEyMyIsImlhdCI6MTcwMjU0NzQzMSwiZXhwIjoxNzg4OTQ3NDMxfQ.7k2MZSS6GGwrUiwJRt_1mlcG00lngi9TOxHuSiL1XkI";

    /**
     * @Creator: TruongNQ
     * @parameter time
     * @Goal: HttpStatus = 403
     * @Throw: Exception
     */
    @Test
    public void getTotalRevenue_time_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/overview/revenue")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: TruongNQ
     * @parameter time
     * @Goal: HttpStatus = 403
     * @Throw: Exception
     */
    @Test
    public void getTotalRevenue_time_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/overview/revenue/{time}", "")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: TruongNQ
     * @parameter time
     * @Goal: HttpStatus = 200
     * @Throw: Exception
     */
    @Test
    public void getTotalRevenue_time_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/overview/revenue/{time}", "month")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
