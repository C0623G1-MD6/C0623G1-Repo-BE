package com.example.fashion.repository.invoice;

import com.example.fashion.dto.invoice.InvoiceDto;
import com.example.fashion.model.customer.Customer;
import com.example.fashion.model.invoice.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface IInvoiceRepository extends JpaRepository<Invoice, Integer> {

//    /**
//     * The method help to save invoices to database.
//     * @author NhatNk
//     * @since 2023-12-12
//     * @param invoiceCode is an object containing invoice.invoiceCode information
//     * @param invoicePrintingDate is an object containing invoice.invoicePrintingDate information
//     * @param customerId is an object containing invoice.customerId information
//     * @param employeeId is an object containing invoice information
//     */
//    @Transactional
//    @Modifying
//    @Query(value = "insert into invoices (invoice_code, invoice_printing_date, customer_id, employee_id) " +
//            "values ( :#{#invoiceDto.invoiceCode}, :#{#invoiceDto.invoicePrintingDate}, :#{#invoiceDto.customerId}, :#{#invoiceDto.employeeId})",
//            nativeQuery = true)
//    void saveInvoice(@Param("invoice") InvoiceDto invoiceDto);

    /**
     * The method help to save invoices to database.
     * @author NhatNk
     * @since 2023-12-12
     * @param invoiceCode is invoice.invoiceCode
     * @param invoicePrintingDate is invoice.invoicePrintingDate
     * @param customerId is invoice.customerId
     * @param employeeId is invoice.employeeId
     */
    @Transactional
    @Modifying
    @Query(value = "insert into invoices (invoice_code, invoice_printing_date, customer_id, employee_id) " +
            "values ( :invoiceCode, :invoicePrintingDate, :customerId, :employeeId)",
            nativeQuery = true)
    void saveInvoice(@Param("invoiceCode") String invoiceCode,
                     @Param("invoicePrintingDate")LocalDateTime invoicePrintingDate,
                     @Param("customerId") Integer customerId,
                     @Param("employeeId") Integer employeeId);
}
