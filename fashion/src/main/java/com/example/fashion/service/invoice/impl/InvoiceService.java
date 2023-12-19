package com.example.fashion.service.invoice.impl;

import com.example.fashion.dto.invoice.InvoiceDto;
import com.example.fashion.repository.invoice.IInvoiceRepository;
import com.example.fashion.service.invoice.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService implements IInvoiceService {
    @Autowired
    private IInvoiceRepository invoiceRepository;


    /**
     * The method help to save invoices.
     *
     * @param invoiceDto is an object containing invoice information
     * @return 200 Ok If no exception occurs
     * @return 400 Bad Request If an exception occurs
     * @author NhatNk
     * @since 2023-12-12
     */
    @Override
    public Boolean saveInvoice(InvoiceDto invoiceDto) {
        try {
            invoiceRepository.saveInvoice(invoiceDto.getInvoiceCode(), invoiceDto.getInvoicePrintingDate(),
                    invoiceDto.getCustomerId(), invoiceDto.getEmployeeId());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * The method help to get invoiceId.
     *
     * @param invoiceCode
     * @return invoiceId If no exception occurs
     * @return null If an exception occurs
     * @author NhatNk
     * @see Integer
     * @since 2023-12-12
     */
    @Override
    public Integer getInvoiceIdByInvoiceCode(String invoiceCode) {
        try {
            return invoiceRepository.getInvoiceIdByInvoiceCode(invoiceCode);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String createInvoiceCode() {
        Integer invoiceCounter = invoiceRepository.getLastInvoiceId() + 1;
        return String.format("HD-%06d", invoiceCounter);
    }
}
