package com.example.fashion.repository.invoice;

import com.example.fashion.model.customer.Customer;
import com.example.fashion.model.invoice.Invoice;
import com.example.fashion.model.invoice.InvoiceDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IInvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into invoice_details (selling_quantity, invoice_id, product_id) " +
            "values ( :#{#invoiceDetail.sellingQuantity},  :#{#invoiceDetail.invoice.id},  :#{#invoiceDetail.product.id})",
            nativeQuery = true)
    void saveInvoiceDetail(@Param("invoiceDetail") InvoiceDetail invoiceDetail);
}
