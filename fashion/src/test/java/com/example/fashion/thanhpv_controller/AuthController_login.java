package com.example.fashion.thanhpv_controller;

import com.example.fashion.dto.Login;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class AuthController_login {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * @Creator: ThanhPV
     * @parameter username equals null
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void login_username_13() throws Exception {
        Login login = new Login();
        login.setUsername(null);
        login.setPassword("123456789");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(null))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: ThanhPV
     * @parameter username is empty
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void login_username_14() throws Exception {
        Login login = new Login();
        login.setUsername("");
        login.setPassword("123456789");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(login))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: ThanhPV
     * @parameter username is not in correct format
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void login_username_15() throws Exception {
        Login login = new Login();
        login.setUsername("admin123$%#");
        login.setPassword("123456789");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(login))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: ThanhPV
     * @parameter username is not greater than or equal to min length
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void login_username_16() throws Exception {
        Login login = new Login();
        login.setUsername("adm");
        login.setPassword("123456789");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(login))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: ThanhPV
     * @parameter username is not less than or equal to max length
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void login_username_17() throws Exception {
        Login login = new Login();
        login.setUsername("C0623G1C0623G1C0623G1C0623G1C0623G1C0623G1C0623G1C0623G1C0623G1C0623G1C0623G1C0623G1C0623G1C0623G1C0623G");
        login.setPassword("123456789");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(login))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: ThanhPV
     * @parameter username does not exist in the database
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void login_username_99() throws Exception {
        Login login = new Login();
        login.setUsername("admin1234");
        login.setPassword("123456789");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(login))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: ThanhPV
     * @parameter password equals null
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void login_password_13() throws Exception {
        Login login = new Login();
        login.setUsername("admin123");
        login.setPassword(null);
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(null))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * @Creator: ThanhPV
     * @parameter password is empty
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void login_password_14() throws Exception {
        Login login = new Login();
        login.setUsername("admin123");
        login.setPassword("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(login))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * @Creator: ThanhPV
     * @parameter password is not in correct format
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void login_password_15() throws Exception {
        Login login = new Login();
        login.setUsername("admin123");
        login.setPassword("123456789<script>");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(login))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: ThanhPV
     * @parameter password is not greater than or equal to min length
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void login_password_16() throws Exception {
        Login login = new Login();
        login.setUsername("admin123");
        login.setPassword("123");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(login))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: ThanhPV
     * @parameter password is not less than or equal to max length
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void login_password_17() throws Exception {
        Login login = new Login();
        login.setUsername("C0623G1C0623G1C0623G1C0623G1C0623G1C0623G1C0623G1C0623G1C0623G1C0623G1C0623G1C0623G1C0623G1C0623G1C0623G");
        login.setPassword("123456789");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(login))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * @Creator: ThanhPV
     * @parameter incorrect password
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void login_password_99() throws Exception {
        Login login = new Login();
        login.setUsername("admin123");
        login.setPassword("123456789000");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(login))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * @Creator: ThanhPV
     * @parameter username and password valid
     * @Goal: HttpStatus = 4xx
     * @Throw: Exception
     */
    @Test
    public void login_success_18() throws Exception {
        Login login = new Login();
        login.setUsername("admin123");
        login.setPassword("123456789");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/login")
                                .content(this.objectMapper.writeValueAsString(login))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
