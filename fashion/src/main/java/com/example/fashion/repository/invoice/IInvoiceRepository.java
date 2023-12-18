package com.example.fashion.repository.invoice;

import com.example.fashion.model.invoice.Invoice;
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

    /**
     * The method help to get invoiceId from database.
     * @author NhatNk
     * @since 2023-12-17
     * @param invoiceCode
     * @return invoiceId
     * @see Integer
     */
    @Query(value = "select invoices.id from invoices where invoices.invoice_code = :invoiceCode",nativeQuery = true)
    Integer getInvoiceIdByInvoiceCode(@Param("invoiceCode") String invoiceCode);

    /**
     * The method help to get invoiceCode from database.
     * @author NhatNk
     * @since 2023-12-17
     * @return invoiceCode
     * @see String
     */
    @Query(value = "select id from invoices order by id desc limit 1",nativeQuery = true)
    Integer getLastInvoiceId();
}
