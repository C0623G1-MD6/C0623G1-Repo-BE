package com.example.fashion.TriVN_controller;

import com.example.fashion.dto.notificationDto.NotificationDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.awt.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class notificationRestControllerCreate {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    /**
     * TriVN
     * input title null
     *
     * @throws Exception
     */
    @Test
    public void create_title_13() throws Exception {
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setTitle(null);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/notification/add")
                                .content(this.objectMapper.writeValueAsString(notificationDTO))
                                .content(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * TriVN
     * input title is empty
     *
     * @throws Exception
     */
    @Test
    public void create_title_14() throws Exception {
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setTitle("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/notification/add")
                                .content(this.objectMapper.writeValueAsString(notificationDTO))
                                .content(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * TriVN
     * input title max length
     *
     * @throws Exception
     */
    @Test
    public void create_title_17() throws Exception {
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setTitle("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/notification/add")
                                .content(this.objectMapper.writeValueAsString(notificationDTO))
                                .content(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * TriVn
     * input content null
     *
     * @throws Exception
     */
    @Test
    public void create_content_13() throws Exception {
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setContent(null);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/notification/add")
                                .content(this.objectMapper.writeValueAsString(notificationDTO))
                                .content(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * TriVN
     * input content is empty
     *
     * @throws Exception
     */
    @Test
    public void create_content_14() throws Exception {
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setContent("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/notification/add")
                                .content(this.objectMapper.writeValueAsString(notificationDTO))
                                .content(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * TriVN
     * input content max length
     *
     * @throws Exception
     */
    @Test
    public void create_content_17() throws Exception {
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setContent("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/notification/add")
                                .content(this.objectMapper.writeValueAsString(notificationDTO))
                                .content(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * TriVn
     * Create success
     * @throws Exception
     */
    @Test
    public void createNotification_18() throws Exception {
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setTitle("Cảnh cáo");
        notificationDTO.setContent("Dạo này nhân viên đi làm trể rất nhiều, cần chấn chỉnh lại");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/notification/add")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(this.objectMapper.writeValueAsString(notificationDTO))
                ).andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
