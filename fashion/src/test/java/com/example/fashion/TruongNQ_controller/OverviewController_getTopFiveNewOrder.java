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
public class OverviewController_getTopFiveNewOrder {
    @Autowired
    private MockMvc mockMvc;

    private final String TOKEN_VALID = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbjEyMyIsImlhdCI6MTcwMjYwNDM5MCwiZXhwIjoxNzg5MDA0MzkwfQ.vkzdQTnNCzibRAbTRMq055No6pDsGGBpnntvL3Qxy9o";

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
                                .get("/api/overview/top_new_order")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("[0].name").value("Nguyễn Văn A"))
                .andExpect(jsonPath("[0].id").value(1))
                .andExpect(jsonPath("[0].date").value("2023-12-14 00:00:00.0"))
                .andExpect(jsonPath("[0].total").value(4.0))
                .andExpect(jsonPath("[4].name").value("Nguyễn Văn E"))
                .andExpect(jsonPath("[4].id").value(5))
                .andExpect(jsonPath("[4].date").value("2023-12-14 00:00:00.0"))
                .andExpect(jsonPath("[4].total").value(8.0));
    }
}
