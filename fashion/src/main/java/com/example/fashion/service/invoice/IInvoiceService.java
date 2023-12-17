package com.example.fashion.service.invoice;

import com.example.fashion.dto.invoice.InvoiceDto;
import com.example.fashion.model.invoice.Invoice;

public interface IInvoiceService {
    Boolean saveInvoice(InvoiceDto invoiceDto);
}
