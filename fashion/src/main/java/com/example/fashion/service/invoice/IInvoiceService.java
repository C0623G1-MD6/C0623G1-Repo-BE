package com.example.fashion.service.invoice;

import ch.qos.logback.core.model.INamedModel;
import com.example.fashion.model.customer.Customer;
import com.example.fashion.model.invoice.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IInvoiceService {
    Boolean saveInvoice(Invoice invoice);
    Page<Customer> getAllCustomer(Pageable pageable, String keyword);
    Page<Invoice> getAllInvoice(Pageable pageable, String keyword);
}
