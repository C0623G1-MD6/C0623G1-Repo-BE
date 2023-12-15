package com.example.fashion.TruongNQ_controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OverviewController_getTotalCustomer {
    @Autowired
    private MockMvc mockMvc;

    private final String TOKEN_VALID = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbjEyMyIsImlhdCI6MTcwMjYwNDM5MCwiZXhwIjoxNzg5MDA0MzkwfQ.vkzdQTnNCzibRAbTRMq055No6pDsGGBpnntvL3Qxy9o";

    /**
     * @Creator: TruongNQ
     * @parameter time
     * @Goal: HttpStatus = 403
     * @Throw: Exception
     */
    @Test
    public void getTotalCustomer_time_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/overview/total_customer")
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
    public void getTotalCustomer_time_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/overview/total_customer/{time}", "")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: TruongNQ
     * @parameter time = week
     * @Goal: HttpStatus = 200
     * @Throw: Exception
     */
    @Test
    public void getTotalCustomer_week_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/overview/total_customer/{time}", "week")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$").value(5));
    }
    /**
     * @Creator: TruongNQ
     * @parameter time = month
     * @Goal: HttpStatus = 200
     * @Throw: Exception
     */
    @Test
    public void getTotalCustomer_month_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/overview/total_customer/{time}", "month")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$").value(5));
    }
    /**
     * @Creator: TruongNQ
     * @parameter time = year
     * @Goal: HttpStatus = 200
     * @Throw: Exception
     */
    @Test
    public void getTotalCustomer_year_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/overview/total_customer/{time}", "year")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$").value(6));;
    }
}
