package com.example.fashion.service.invoice;

import com.example.fashion.model.customer.Customer;
import com.example.fashion.model.invoice.InvoiceDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IInvoiceDetailService {
    Boolean saveInvoiceDetail(InvoiceDetail invoiceDetail);
}
