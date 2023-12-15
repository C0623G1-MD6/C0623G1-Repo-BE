package com.example.fashion.home_controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class homePageController_getListProduct {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAllProducts_7() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    @Test void findAllProducts_8() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home").param("option","")))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void findAllProducts_10() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home").param("option","price")
                ))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
    @Test
    void findAllProducts_11() throws  Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                        "/api/home?page=0"
                                ).param("option","price")
                                .param("sort", "ASC")
                )
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(4))
                .andExpect(jsonPath("totalElements").value(15))
                .andExpect(jsonPath("content[0].percent").value(0.1))
                .andExpect(jsonPath("content[0].productCode").value("A-0003"))
                .andExpect(jsonPath("content[0].productId").value(3))
                .andExpect(jsonPath("content[0].gender").value(true))
                .andExpect(jsonPath("content[0].price").value(799000.0))
                .andExpect(jsonPath("content[0].productName").value("Áo Gi Lê Vải Mềm Dệt Kim"))
                .andExpect(jsonPath("content[0].categoryName").value("Áo"))
                .andExpect(jsonPath("content[3].percent").value(0.05))
                .andExpect(jsonPath("content[3].productCode").value("A-0001"))
                .andExpect(jsonPath("content[3].productId").value(1))
                .andExpect(jsonPath("content[3].gender").value(true))
                .andExpect(jsonPath("content[3].price").value(1299000.0))
                .andExpect(jsonPath("content[3].productName").value("Áo Sơ Mi Vải Poplin"))
                .andExpect(jsonPath("content[3].categoryName").value("Áo"));
    }
    @Test
    public void findAllProducts_9() throws Exception {
        this.mockMvc.perform((MockMvcRequestBuilders.get("/api/home").param("option","price")
                        .param("sort", "DCSF")
                ))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}
