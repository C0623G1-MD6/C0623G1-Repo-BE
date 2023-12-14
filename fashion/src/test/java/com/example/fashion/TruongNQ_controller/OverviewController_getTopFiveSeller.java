package com.example.fashion.TruongNQ_controller;

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
public class OverviewController_getTopFiveSeller {
    @Autowired
    private MockMvc mockMvc;

    private final String TOKEN_VALID = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbjEyMyIsImlhdCI6MTcwMjU0NzQzMSwiZXhwIjoxNzg4OTQ3NDMxfQ.7k2MZSS6GGwrUiwJRt_1mlcG00lngi9TOxHuSiL1XkI";

    /**
     * @Creator: TruongNQ
     * @Goal: HttpStatus = 200
     * @Result: list size > 0
     * @Throw: Exception
     */
    @Test
    public void getTopFiveSeller_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/overview/top_seller")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("[0].name").value("Nguyễn Văn E"))
                .andExpect(jsonPath("[0].quantity").value(8))
                .andExpect(jsonPath("[0].revenue").value(15992000))
                .andExpect(jsonPath("[4].name").value("Nguyễn Văn C"))
                .andExpect(jsonPath("[4].quantity").value(6))
                .andExpect(jsonPath("[4].revenue").value(4794000));
    }
}
