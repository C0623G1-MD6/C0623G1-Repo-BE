package com.example.fashion.service.invoice.impl;

import com.example.fashion.model.customer.Customer;
import com.example.fashion.model.invoice.Invoice;
import com.example.fashion.repository.customerRepository.ICustomerRepository;
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

    @Autowired
    private ICustomerRepository customerRepository;

    /**
     * The method help to save invoices.
     * @author NhatNk
     * @since 2023-12-12
     * @param invoice is an object containing invoice information
     * @return 200 Ok If no exception occurs
     * @return 400 Bad Request If an exception occurs
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
