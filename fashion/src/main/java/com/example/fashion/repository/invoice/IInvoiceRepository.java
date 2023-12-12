package com.example.fashion.repository.invoice;

import com.example.fashion.model.invoice.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvoiceRepository extends JpaRepository<Invoice, Integer> {
}
