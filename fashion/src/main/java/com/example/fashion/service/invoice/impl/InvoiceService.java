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
     * @author NhatNk
     * @since 2023-12-12
     * @param invoiceDto is an object containing invoice information
     * @return 200 Ok If no exception occurs
     * @return 400 Bad Request If an exception occurs
     */
    @Override
    public Boolean saveInvoice(InvoiceDto invoiceDto) {
        try {
            invoiceRepository.saveInvoice(invoiceDto.getInvoiceCode(),invoiceDto.getInvoicePrintingDate(),
                    invoiceDto.getCustomerId(), invoiceDto.getEmployeeId());
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
