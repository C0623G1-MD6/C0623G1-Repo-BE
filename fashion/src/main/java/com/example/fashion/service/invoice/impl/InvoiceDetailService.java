package com.example.fashion.service.invoice.impl;

import com.example.fashion.model.invoice.InvoiceDetail;
import com.example.fashion.repository.invoice.IInvoiceDetailRepository;
import com.example.fashion.service.invoice.IInvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceDetailService implements IInvoiceDetailService {
    @Autowired
    private IInvoiceDetailRepository invoiceDetailRepository;

    @Override
    public Boolean saveInvoiceDetail(InvoiceDetail invoiceDetail) {
        try {
            invoiceDetailRepository.save(invoiceDetail);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
