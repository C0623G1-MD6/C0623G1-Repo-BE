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

    @Transactional
    @Modifying
    @Query(value = "insert into invoices (invoice_code, invoice_printing_date, customer_id, employee_id) " +
            "values ( :#{#invoice.invoiceCode}, :#{#invoice.invoicePrintingDate}, :#{#invoice.customer.id}, :#{#invoice.employee.id})",
            nativeQuery = true)
    void saveInvoice(@Param("invoice") Invoice invoice);

    @Query(value = "SELECT customers.id, customers.customer_code, customers.name, customers.phone, customers.is_deleted, customer_type.discount_percent" +
            "from customers "+
            "JOIN customer_type " +
            "ON customers.customer_type_id = customer_type.id "+
            "where " +
            "customers.is_deleted = '0' "+
            "and (customers.customer_code like :keyword " +
            "or customers.name like :keyword" +
            "or customers.phone like :keyword)"
            , nativeQuery = true)
    Page<Customer> getAllC(Pageable pageable, @Param("keyword") String keyword);
}
