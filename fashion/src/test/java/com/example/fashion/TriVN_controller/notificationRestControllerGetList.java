package com.example.fashion.TriVN_controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class notificationRestControllerGetList {
    @Autowired
    private MockMvc mockMvc;

    /**
     * TriVn
     * list notification in sales
     * @throws Exception
     */
    @Test
    public void showListNotificationSale_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/notification/list/sales"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void showListSale_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/notification/list/sales"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(4))
                .andExpect(jsonPath("totalElements").value(16))
                .andExpect(jsonPath("content[0].noticePostingDate").value("2023-12-01 00:00:00.000000"))
                .andExpect(jsonPath("content[0].content").value("Khuyến Mãi 12/2023: giảm giá các mặt hàng áo khoác gió nam và nữ"))
                .andExpect(jsonPath("content[0].title").value("Khuyến Mãi 12/2023"))
                .andExpect(jsonPath("content[0].deleted").value("true"))
                 .andExpect(jsonPath("content[4].noticePostingDate").value("2023-12-02 00:00:00.000000"))
                .andExpect(jsonPath("content[4].content").value("Cảnh cáo nhân viên sale: không được tụ tập trong giờ làm"))
                .andExpect(jsonPath("content[4].title").value("Cảnh cáo nhân viên sale"))
                .andExpect(jsonPath("content[4].deleted").value("true"));
    }

}
