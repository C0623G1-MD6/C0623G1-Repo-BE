package com.example.fashion.thanhpv_controller;

import com.example.fashion.dto.auth.ChangePassword;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthController_changePassword {
    private static final String TOKEN_VALID = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbjEyMyIsImlhdCI6MTcwMjUyNjk3MSwiZXhwIjoxNzg4OTI2OTcxfQ.pb1FYC6LubV1HTNmiub3_cljHaKG4KmVV3AHGxRtZnM";
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * token is valid
     *
     * @Creator: ThanhPV
     * @parameter username equals null
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void changePassword_username_19() throws Exception {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setUsername(null);
        changePassword.setPassword("123456789");
        changePassword.setPasswordNew("1234567890");
        changePassword.setPasswordNewAgain("1234567890");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .content(this.objectMapper.writeValueAsString(changePassword))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.username").value("Trường username không được để trống."));
    }

    /**
     * token is valid
     *
     * @Creator: ThanhPV
     * @parameter username is empty
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void changePassword_username_20() throws Exception {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setUsername("");
        changePassword.setPassword("123456789");
        changePassword.setPasswordNew("1234567890");
        changePassword.setPasswordNewAgain("1234567890");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .content(this.objectMapper.writeValueAsString(changePassword))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.username").value("Trường username không được để trống."));
    }

    /**
     * token is valid
     *
     * @Creator: ThanhPV
     * @parameter username is not in correct format
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void changePassword_username_21() throws Exception {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setUsername("admin123#$%");
        changePassword.setPassword("123456789");
        changePassword.setPasswordNew("1234567890");
        changePassword.setPasswordNewAgain("1234567890");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .content(this.objectMapper.writeValueAsString(changePassword))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.username").value("Chỉ được chứa ký tự alphabet, số và dấu gạch dưới"));
    }

    /**
     * token is valid
     *
     * @Creator: ThanhPV
     * @parameter username is too short
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void changePassword_username_22() throws Exception {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setUsername("adm");
        changePassword.setPassword("123456789");
        changePassword.setPasswordNew("1234567890");
        changePassword.setPasswordNewAgain("1234567890");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .content(this.objectMapper.writeValueAsString(changePassword))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.username").value("Username phải trên 8 kí tự"));
    }

    /**
     * token is valid
     *
     * @Creator: ThanhPV
     * @parameter username is too long
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void changePassword_username_23() throws Exception {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setUsername("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
        changePassword.setPassword("123456789");
        changePassword.setPasswordNew("1234567890");
        changePassword.setPasswordNewAgain("1234567890");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .content(this.objectMapper.writeValueAsString(changePassword))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.username").value("Username không được nhiều hơn 30 ký tự"));
    }

    /**
     * token is valid
     *
     * @Creator: ThanhPV
     * @parameter username does not exist in the database
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void changePassword_username_99() throws Exception {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setUsername("admin12345");
        changePassword.setPassword("123456789");
        changePassword.setPasswordNew("1234567890");
        changePassword.setPasswordNewAgain("1234567890");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .content(this.objectMapper.writeValueAsString(changePassword))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.username").value("Username không tồn tại"));
        ;
    }

    /**
     * token is valid
     *
     * @Creator: ThanhPV
     * @parameter password equals null
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void changePassword_password_19() throws Exception {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setUsername("admin123");
        changePassword.setPassword(null);
        changePassword.setPasswordNew("1234567890");
        changePassword.setPasswordNewAgain("1234567890");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .content(this.objectMapper.writeValueAsString(changePassword))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.password").value("Trường password không được để trống."));
        ;
    }

    /**
     * token is valid
     *
     * @Creator: ThanhPV
     * @parameter password is empty
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void changePassword_password_20() throws Exception {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setUsername("admin123");
        changePassword.setPassword(null);
        changePassword.setPasswordNew("1234567890");
        changePassword.setPasswordNewAgain("1234567890");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .content(this.objectMapper.writeValueAsString(changePassword))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.password").value("Trường password không được để trống."));
    }

    /**
     * token is valid
     *
     * @Creator: ThanhPV
     * @parameter password is not in correct format
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void changePassword_password_21() throws Exception {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setUsername("admin123");
        changePassword.setPassword("admin123#$%");
        changePassword.setPasswordNew("1234567890");
        changePassword.setPasswordNewAgain("1234567890");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .content(this.objectMapper.writeValueAsString(changePassword))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.password").value("Chỉ được chứa ký tự alphabet, số và dấu gạch dưới"));
    }

    /**
     * token is valid
     *
     * @Creator: ThanhPV
     * @parameter password is too short
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void changePassword_password_22() throws Exception {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setUsername("admin123");
        changePassword.setPassword("1");
        changePassword.setPasswordNew("1234567890");
        changePassword.setPasswordNewAgain("1234567890");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .content(this.objectMapper.writeValueAsString(changePassword))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.password").value("Password phải trên 8 kí tự"));
    }

    /**
     * token is valid
     *
     * @Creator: ThanhPV
     * @parameter password is too long
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void changePassword_password_23() throws Exception {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setUsername("admin123");
        changePassword.setPassword("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
        changePassword.setPasswordNew("1234567890");
        changePassword.setPasswordNewAgain("1234567890");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .content(this.objectMapper.writeValueAsString(changePassword))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.password").value("Password không được nhiều hơn 100 ký tự"));
    }

    /**
     * token is valid
     *
     * @Creator: ThanhPV
     * @parameter password is incorrect
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void changePassword_password_99() throws Exception {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setUsername("admin123");
        changePassword.setPassword("123456781119");
        changePassword.setPasswordNew("1234567890");
        changePassword.setPasswordNewAgain("1234567890");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .content(this.objectMapper.writeValueAsString(changePassword))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.password").value("Mật khẩu không chính xác"));
        ;
    }

    /**
     * token is valid
     *
     * @Creator: ThanhPV
     * @parameter passwordNew equals null
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void changePassword_passwordNew_19() throws Exception {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setUsername("admin123");
        changePassword.setPassword("123456789");
        changePassword.setPasswordNew(null);
        changePassword.setPasswordNewAgain("1234567890");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .content(this.objectMapper.writeValueAsString(changePassword))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.passwordNew").value("Mật khẩu mới không được trống"));
        ;
    }

    /**
     * token is valid
     *
     * @Creator: ThanhPV
     * @parameter passwordNew is empty
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void changePassword_passwordNew_20() throws Exception {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setUsername("admin123");
        changePassword.setPassword("123456789");
        changePassword.setPasswordNew("");
        changePassword.setPasswordNewAgain("1234567890");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .content(this.objectMapper.writeValueAsString(changePassword))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.passwordNew").value("Mật khẩu mới không được trống"));
    }

    /**
     * token is valid
     *
     * @Creator: ThanhPV
     * @parameter passwordNew is not in correct format
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void changePassword_passwordNew_21() throws Exception {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setUsername("admin123");
        changePassword.setPassword("123456789");
        changePassword.setPasswordNew("admin123#$%");
        changePassword.setPasswordNewAgain("admin123#$%");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .content(this.objectMapper.writeValueAsString(changePassword))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.passwordNew").value("Chỉ được chứa ký tự alphabet, số và dấu gạch dưới"));
    }

    /**
     * token is valid
     *
     * @Creator: ThanhPV
     * @parameter passwordNew is too short
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void changePassword_passwordNew_22() throws Exception {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setUsername("admin123");
        changePassword.setPassword("123456789");
        changePassword.setPasswordNew("1");
        changePassword.setPasswordNewAgain("1");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .content(this.objectMapper.writeValueAsString(changePassword))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.passwordNew").value("Mật khẩu mới phải trên 8 kí tự"));
    }

    /**
     * token is valid
     *
     * @Creator: ThanhPV
     * @parameter passwordNew is too long
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void changePassword_passwordNew_23() throws Exception {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setUsername("admin123");
        changePassword.setPassword("123456789");
        changePassword.setPasswordNew("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
        changePassword.setPasswordNewAgain("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .content(this.objectMapper.writeValueAsString(changePassword))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.passwordNew").value("Mật khẩu mới không được nhiều hơn 100 ký tự"));
    }
    /**
     * token is valid
     *
     * @Creator: ThanhPV
     * @parameter passwordNewAgain Re-enter the password that is not the same as the new password
     * @Goal: HttpStatus = 400
     * @Throw: Exception
     */
    @Test
    public void changePassword_passwordNewAgain_19() throws Exception {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setUsername("admin123");
        changePassword.setPassword("123456789");
        changePassword.setPasswordNew("123456789adm");
        changePassword.setPasswordNewAgain("");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .content(this.objectMapper.writeValueAsString(changePassword))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.passwordNewAgain").value("Mật khẩu nhập lại không khớp."));
        ;
    }

    @Test
    public void changePassword_success_24() throws Exception {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setUsername("admin123");
        changePassword.setPassword("123456789");
        changePassword.setPasswordNew("123456789adm");
        changePassword.setPasswordNewAgain("123456789adm");
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/changePassword")
                                .header("Authorization", "Bearer " + TOKEN_VALID)
                                .content(this.objectMapper.writeValueAsString(changePassword))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$").value("Đổi mật khẩu thành công !"));
    }
}
