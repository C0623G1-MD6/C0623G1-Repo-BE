package com.example.fashion.HungHLP_controller;
import com.example.fashion.dto.newsdto.NewsDto;
import com.example.fashion.model.news.NewsCategory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class NewsRestController_create {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Creator: HungHLP
     * parameter name = null
     * Goal: HttpStatus = 400
     * Date create : 13-12-2023
     * @Throw: Exception
     */
    @Test
    public void create_name_13() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setName(null);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/news/create")
                                .content(this.objectMapper.writeValueAsString(null))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());

    }

    /**
     * Creator: HungHLP
     * parameter name is empty
     * Goal: HttpStatus = 400
     * Date create : 13-12-2023
     * @Throw: Exception
     */
    @Test
    public void create_name_14() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setName("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/news/create")
                                .content(this.objectMapper.writeValueAsString(newsDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    /**
     * Creator: HungHLP
     * parameter name is wrong format
     * Goal: HttpStatus = 400
     * Date create : 13-12-2023
     * @Throw: Exception
     */
    @Test
    public void create_name_15() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setName("Fashion$#%");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/news/create")
                                .content(this.objectMapper.writeValueAsString(newsDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * Creator: HungHLP
     * parameter name <=minlength
     * Goal: HttpStatus = 400
     * Date create : 13-12-2023
     * @Throw: Exception
     */
    @Test
    public void create_name_16() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setName("hung");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/news/create")
                                .content(this.objectMapper.writeValueAsString(newsDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator: HungHLP
     * parameter name >=maxlength
     * Goal: HttpStatus = 400
     * Date create : 13-12-2023
     * @Throw: Exception
     */
    @Test
    public void create_name_17() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setName("fashionfashionfashionfashionfashionfashionfashionfashionfashionfashionfashionfashionfashionfashion");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/news/create")
                                .content(this.objectMapper.writeValueAsString(newsDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }




    /**
     * Creator: HungHLP
     * parameter content = null
     * Goal: HttpStatus = 400
     * Date create : 13-12-2023
     * @Throw: Exception
     */
    @Test
    public void create_content_13() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setContent(null);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/news/create")
                                .content(this.objectMapper.writeValueAsString(null))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());

    }

    /**
     * Creator: HungHLP
     * parameter content is empty
     * Goal: HttpStatus = 400
     * Date create : 13-12-2023
     * @Throw: Exception
     */
    @Test
    public void create_content_14() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setContent("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/news/create")
                                .content(this.objectMapper.writeValueAsString(newsDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }



    /**
     * Creator: HungHLP
     * parameter content <=minlength
     * Goal: HttpStatus = 400
     * Date create : 13-12-2023
     * @Throw: Exception
     */
    @Test
    public void create_content_16() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setContent("hung");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/news/create")
                                .content(this.objectMapper.writeValueAsString(newsDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    /**
     * Creator: HungHLP
     * parameter content >=maxlength
     * Goal: HttpStatus = 400
     * Date create : 13-12-2023
     * @Throw: Exception
     */
    @Test
    public void create_content_17() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setContent("fashionfashionfashionfashionfashionfashionfashionfashioonfasionfashionfashionfashionfashionfashionfashionfashioonfashionfashionfashionfashionfashionfashionfashionfashioonfashionfashionfashionfashionfashionfashionfashionfashioonfashionfashionfashionfashionfashionfashionfashionfashioonfashionfashionfashionfashionfashionfashionfashionfashioonfashionfashionfashionfashionfashionfashionfashionfashioonfashhion");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/news/create")
                                .content(this.objectMapper.writeValueAsString(newsDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    /**
     * Creator: HungHLP
     * input image = null
     * Goal: HttpStatus = 400
     * Date create : 13-12-2023
     * @Throw: Exception
     */
    @Test
    public void create_image_13() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setImage(null);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/news/create")
                                .content(this.objectMapper.writeValueAsString(null))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());

    }

    /**
     * Creator: HungHLP
     * parameter image is empty
     * Goal: HttpStatus = 400
     * Date create : 13-12-2023
     * @Throw: Exception
     */
    @Test
    public void create_image_14() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setImage("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/news/create")
                                .content(this.objectMapper.writeValueAsString(newsDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }



    /**
     * Creator: HungHLP
     * input dateCreate = null
     * Goal: HttpStatus = 400
     * Date create : 13-12-2023
     * @Throw: Exception
     */
    @Test
    public void create_dateCreate_13() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setDateCreate(null);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/news/create")
                                .content(this.objectMapper.writeValueAsString(null))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());

    }


    /**
     * Creator: HungHLP
     * parameter Object News valid
     * Goal: HttpStatus = 200
     * Date create : 13-12-2023
     * @Throw: Exception
     */
    @Test
    public void create_news_18() throws Exception {
        NewsDto newsDto = new NewsDto();
        newsDto.setName("fashion");
        newsDto.setContent("Fashion Week hay còn được biết đến là tuần lễ thời trang là một trong những sự kiện thời trang đáng chú ý nhất của ngành hàng này. Trong khuôn khổ của tuần lễ, các nhà mốt cùng nhiều tên tuổi Fashionista/Influencer sẽ góp mặt tại đây, cùng xuất hiện với những bộ sưu tập mới nhất của các thương hiệu, qua đó giúp thu hút sự chú ý về mặt truyền thông lẫn trong mắt khách hàng. Fashion Week thường kéo dài từ 5 7 ngày, với 4 tuần lễ thời trang gây được nhiều chú ý nhất trên thế giới");
        newsDto.setNewsCategoryId(1);
        newsDto.setImage("https://mcdn.coolmate.me/uploads/October2021/Fashion_Week_02.jpg");
        newsDto.setDateCreate(LocalDateTime.parse("2023-12-12T00:00:00"));
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/news/create")
                                .content(this.objectMapper.writeValueAsString(newsDto))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isCreated());

    }

}
