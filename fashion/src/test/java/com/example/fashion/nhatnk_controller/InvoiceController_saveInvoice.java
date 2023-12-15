package com.example.fashion.nhatnk_controller;

import com.example.fashion.dto.invoice.InvoiceDto;
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
public class InvoiceController_saveInvoice {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * The method helps check in case the invoiceCode parameter is null
     *
     * @param invoiceCode = null
     * @param invoicePrintingDate = 2023-12-14T11:26:00
     * @param customerId = 4
     * @param employeeId = 1
     * @return 400 Bad Request
     * @throws Exception
     * @author NhatNk
     * @since 2023-12-14
     */
    @Test
    public void saveInvoice_invoiceCode_13() throws Exception {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setInvoiceCode(null);

        invoiceDto.setInvoicePrintingDate(LocalDateTime.parse("2023-12-14T11:26:00"));
        invoiceDto.setCustomerId(4);
        invoiceDto.setEmployeeId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/invoices/save-invoice")
                        .content(this.objectMapper.writeValueAsString(invoiceDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * The method helps check in case the invoicePrintingDate parameter is null
     *
     * @param invoiceCode = HD-000023
     * @param invoicePrintingDate = null
     * @param customerId = 4
     * @param employeeId = 1
     * @return 400 Bad Request
     * @throws Exception
     * @author NhatNk
     * @since 2023-12-14
     */
    @Test
    public void saveInvoice_invoicePrintingDate_13() throws Exception {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setInvoiceCode("HD-000023");

        invoiceDto.setInvoicePrintingDate(null);
        invoiceDto.setCustomerId(4);
        invoiceDto.setEmployeeId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/invoices/save-invoice")
                        .content(this.objectMapper.writeValueAsString(invoiceDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * The method helps check in case the customerId parameter is null
     *
     * @param invoiceCode = HD-000023
     * @param invoicePrintingDate = 2023-12-14T11:26:00
     * @param customerId = null
     * @param employeeId = 1
     * @return 400 Bad Request
     * @throws Exception
     * @author NhatNk
     * @since 2023-12-14
     */
    @Test
    public void saveInvoice_customerId_13() throws Exception {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setInvoiceCode("HD-000023");

        invoiceDto.setInvoicePrintingDate(LocalDateTime.parse("2023-12-14T11:26:00"));
        invoiceDto.setCustomerId(null);
        invoiceDto.setEmployeeId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/invoices/save-invoice")
                        .content(this.objectMapper.writeValueAsString(invoiceDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * The method helps check in case the employeeId parameter is null
     *
     * @param invoiceCode = HD-000023
     * @param invoicePrintingDate = 2023-12-14T11:26:00
     * @param customerId = 4
     * @param employeeId = null
     * @return 400 Bad Request
     * @throws Exception
     * @author NhatNk
     * @since 2023-12-14
     */
    @Test
    public void saveInvoice_employeeId_13() throws Exception {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setInvoiceCode("HD-000023");

        invoiceDto.setInvoicePrintingDate(LocalDateTime.parse("2023-12-14T11:26:00"));
        invoiceDto.setCustomerId(4);
        invoiceDto.setEmployeeId(null);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/invoices/save-invoice")
                        .content(this.objectMapper.writeValueAsString(invoiceDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * The method helps check in case the invoiceCode parameter is empty
     *
     * @param invoiceCode = ""
     * @param invoicePrintingDate = 2023-12-14T11:26:00
     * @param customerId = 4
     * @param employeeId = 1
     * @return 400 Bad Request
     * @throws Exception
     * @author NhatNk
     * @since 2023-12-14
     */
    @Test
    public void saveInvoice_invoiceCode_14() throws Exception {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setInvoiceCode("");

        invoiceDto.setInvoicePrintingDate(LocalDateTime.parse("2023-12-14T11:26:00"));
        invoiceDto.setCustomerId(4);
        invoiceDto.setEmployeeId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/invoices/save-invoice")
                        .content(this.objectMapper.writeValueAsString(invoiceDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * The method helps check in case the all parameters are valid
     *
     * @param invoiceCode = HD-000023
     * @param invoicePrintingDate = 2023-12-14T11:26:00
     * @param customerId = 4
     * @param employeeId = 1
     * @return 400 Bad Request
     * @throws Exception
     * @author NhatNk
     * @since 2023-12-14
     */
    @Test
    public void saveInvoice_18() throws Exception {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setInvoiceCode("HD-000026");

        invoiceDto.setInvoicePrintingDate(LocalDateTime.parse("2023-12-14T11:26:00"));
        invoiceDto.setCustomerId(4);
        invoiceDto.setEmployeeId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/invoices/save-invoice")
                        .content(this.objectMapper.writeValueAsString(invoiceDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
