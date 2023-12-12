package com.example.fashion.service.invoice.impl;

import com.example.fashion.model.invoice.Invoice;
import com.example.fashion.repository.invoice.IInvoiceRepository;
import com.example.fashion.service.invoice.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService implements IInvoiceService {
    @Autowired
    private IInvoiceRepository invoiceRepository;

    /**
     * method saveInvoice
     * create by NhatNK
     * date 12/12/2023
     * return Boolean
     */
    @Override
    public Boolean saveInvoice(Invoice invoice) {
        try {
            invoiceRepository.save(invoice);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
