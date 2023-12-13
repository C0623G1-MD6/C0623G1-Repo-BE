package com.example.fashion.service.invoice.impl;

import com.example.fashion.model.customer.Customer;
import com.example.fashion.model.invoice.Invoice;
import com.example.fashion.repository.invoice.IInvoiceRepository;
import com.example.fashion.service.invoice.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Customer> getAllCustomer(Pageable pageable, String keyword) {
        try {
            return invoiceRepository.getAllC(pageable, "%"+keyword+"%");
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public Page<Invoice> getAllInvoice(Pageable pageable, String keyword) {
        try {
            return invoiceRepository.getAllInvoice(pageable, "%"+keyword+"%");
        } catch (Exception e){
            return null;
        }
    }
}
