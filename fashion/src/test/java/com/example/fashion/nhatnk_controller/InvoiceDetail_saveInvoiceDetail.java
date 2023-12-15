package com.example.fashion.nhatnk_controller;

import com.example.fashion.dto.invoice.InvoiceDetailDto;
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
public class InvoiceDetail_saveInvoiceDetail {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * The method helps check in case the sellingQuantity parameter is null
     *
     * @param sellingQuantity = null
     * @param invoiceId = 24
     * @param sizeDetailId = 47
     * @return 400 Bad Request
     * @throws Exception
     * @author NhatNk
     * @since 2023-12-14
     */
    @Test
    public void saveInvoiceDetail_sellingQuantity_13() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        invoiceDetailDto.setSellingQuantity(null);
        invoiceDetailDto.setInvoiceId(24);
        invoiceDetailDto.setSizeDetailId(47);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/invoices/save-invoice-detail")
                        .content(this.objectMapper.writeValueAsString(invoiceDetailDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * The method helps check in case the invoiceDto parameter is null
     *
     * @param sellingQuantity = 5
     * @param invoiceDtoId = null
     * @param sizeDetailId = 47
     * @return 400 Bad Request
     * @throws Exception
     * @author NhatNk
     * @since 2023-12-14
     */
    @Test
    public void saveInvoiceDetail_invoiceId_13() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        invoiceDetailDto.setSellingQuantity(5);
        invoiceDetailDto.setInvoiceId(null);
        invoiceDetailDto.setInvoiceId(47);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/invoices/save-invoice-detail")
                        .content(this.objectMapper.writeValueAsString(invoiceDetailDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * The method helps check in case the sizeDetailDto parameter is null
     *
     * @param sellingQuantity = 5
     * @param invoiceId = 24
     * @param sizeDetailId = null
     * @return 400 Bad Request
     * @throws Exception
     * @author NhatNk
     * @since 2023-12-14
     */
    @Test
    public void saveInvoiceDetail_sizeDetailId_13() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        invoiceDetailDto.setSellingQuantity(5);
        invoiceDetailDto.setInvoiceId(24);
        invoiceDetailDto.setSizeDetailId(null); 

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/invoices/save-invoice-detail")
                        .content(this.objectMapper.writeValueAsString(invoiceDetailDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    

    /**
     * The method helps check in case the all parameters are valid
     *
     * @param sellingQuantity = 5
     * @param invoiceId = 24
     * @param sizeDetailId = 47
     * @return 200 OK
     * @throws Exception
     * @author NhatNk
     * @since 2023-12-14
     */
    @Test
    public void saveInvoiceDetail_18() throws Exception {
        InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
        invoiceDetailDto.setSellingQuantity(5);
        invoiceDetailDto.setInvoiceId(24);
        invoiceDetailDto.setSizeDetailId(47); 

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/invoices/save-invoice-detail")
                        .content(this.objectMapper.writeValueAsString(invoiceDetailDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
