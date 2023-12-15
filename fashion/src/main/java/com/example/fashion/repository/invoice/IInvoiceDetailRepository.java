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
import org.springframework.security.core.parameters.P;
import org.springframework.transaction.annotation.Transactional;

public interface IInvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {

//    /**
//     * The method help to save invoiceDetail to database.
//     * @author NhatNk
//     * @since 2023-12-14
//     * @param invoiceDetail is an object containing invoiceDetail information
//     */
//    @Transactional
//    @Modifying
//    @Query(value = "insert into invoice_details (selling_quantity, invoice_id, product_id) " +
//            "values ( :#{#invoiceDetail.sellingQuantity},  :#{#invoiceDetail.invoice.id},  :#{#invoiceDetail.product.id})",
//            nativeQuery = true)
//    void saveInvoiceDetail(@Param("invoiceDetail") InvoiceDetail invoiceDetail);

    /**
     * The method help to save invoiceDetail to database.
     * @author NhatNk
     * @since 2023-12-14
     * @param sellingQuantity is invoiceDetailDto.sellingQuantity information
     * @param invoiceId is invoiceDetailDto.invoiceId information
     * @param sizeDetailId is invoiceDetailDto.sizeDetailId information
     */
    @Transactional
    @Modifying
    @Query(value = "insert into invoice_details (selling_quantity, invoice_id, size_detail_id) " +
            "values ( :sellingQuantity,  :invoiceId,  :sizeDetailId)",
            nativeQuery = true)
    void saveInvoiceDetail(@Param("sellingQuantity") Integer sellingQuantity,
                           @Param("invoiceId") Integer invoiceId,
                           @Param("sizeDetailId") Integer sizeDetailId);
}
