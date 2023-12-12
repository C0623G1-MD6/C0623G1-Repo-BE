package com.example.fashion.repository.invoice;

import com.example.fashion.model.invoice.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {
}
