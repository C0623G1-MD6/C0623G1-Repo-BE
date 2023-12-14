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
public class OverviewController_getTotalOrder {
    @Autowired
    private MockMvc mockMvc;

    private final String TOKEN_VALID = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbjEyMyIsImlhdCI6MTcwMjU0MjExNCwiZXhwIjoxNzg4OTQyMTE0fQ.9hTozHVVGmI_x6rMY1fVKkL4UVU7HAt2UKu7qQleWNc";

    /**
     * @Creator: TruongNQ
     * @parameter time
     * @Goal: HttpStatus = 403
     * @Throw: Exception
     */
    @Test
    public void getTotalOrder_time_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/overview/total_order")
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
    public void getTotalOrder_time_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/overview/total_order/{time}", "")
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
    public void getTotalOrder_time_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/overview/total_order/{time}", "month")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
