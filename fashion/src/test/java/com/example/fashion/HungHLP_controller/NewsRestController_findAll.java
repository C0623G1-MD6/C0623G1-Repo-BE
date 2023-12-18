package com.example.fashion.HungHLP_controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class NewsRestController_findAll {
    @Autowired
    private MockMvc mockMvc;
    /**
     * Creator: HungHLP
     * parameter : newsCategoryId =1
     * Goal: wrong URL
     *return HTTPStatus =404
     * @Throw: Exception
     * Date create : 13-12-2023
     */
    @Test
    public void findAll_newsCategoryId_invalidURL() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/newjhjgsd/1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    /**
     * Creator: HungHLP
     * parameter : newsCategoryId = ""
     * Goal: wrong URL
     *return HTTPStatus =400
     * @Throw: Exception
     * * Date create : 13-12-2023
     */
    @Test
    public void findAll_newsCategoryId_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/news/",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Creator: HungHLP
     * parameter : categoryId = 5
     * Goal: List no content
     *return HTTPStatus =204
     * @Throw: Exception
     * * Date create : 13-12-2023
     */
    @Test
    public void findAll_newsCategoryId_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/news/5"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * Creator: HungHLP
     * parameter : newsCategory id =1
     * Goal: show list
     *return News List with HTTPStatus =200
     * @Throw: Exception
     * Date create : 13-12-2023
     */
    @Test
    public void findAll_newsCategoryId_11()  throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/news/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].name").value("Kinh đô thời trang"))
                .andExpect(jsonPath("$[0].content").value("Fashion Week (hay còn được biết đến là tuần lễ thời trang) là một trong những sự kiện thời trang đáng chú ý nhất của ngành hàng này. Trong khuôn khổ của tuần lễ, các nhà mốt cùng nhiều tên tuổi Fashionista/Influencer sẽ góp mặt tại đây, cùng xuất hiện với những bộ sưu tập mới nhất của các thương hiệu, qua đó giúp thu hút sự chú ý về mặt truyền thông lẫn trong mắt khách hàng. Fashion Week thường kéo dài từ 5 - 7 ngày, với 4 tuần lễ thời trang gây được nhiều chú ý nhất trên thế giới"))
                .andExpect(jsonPath("$[0].image").value("https://mcdn.coolmate.me/uploads/October2021/Fashion_Week_02.jpg"))
                .andExpect(jsonPath("$[0].dateCreate").value("2023-12-12T00:00:00"))
                .andExpect(jsonPath("$[0].newsCategoryId").value(1));
    }

}

