package com.example.fashion.repository.invoice;

import com.example.fashion.model.customer.Customer;
import com.example.fashion.model.invoice.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IInvoiceRepository extends JpaRepository<Invoice, Integer> {

    /**
     * The method help to save invoices to database.
     * @author NhatNk
     * @since 2023-12-12
     * @param invoice is an object containing invoice information
     */
    @Transactional
    @Modifying
    @Query(value = "insert into invoices (invoice_code, invoice_printing_date, customer_id, employee_id) " +
            "values ( :#{#invoice.invoiceCode}, :#{#invoice.invoicePrintingDate}, :#{#invoice.customer.id}, :#{#invoice.employee.id})",
            nativeQuery = true)
    void saveInvoice(@Param("invoice") Invoice invoice);
}
