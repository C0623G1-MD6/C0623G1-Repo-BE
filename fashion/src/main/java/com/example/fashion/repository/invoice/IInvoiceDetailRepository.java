package com.example.fashion.repository.invoice;

import com.example.fashion.model.invoice.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IInvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {

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
    @Query(value = "insert into invoice_details (selling_price, selling_quantity, invoice_id, size_detail_id) " +
            "values ( :sellingPrice, :sellingQuantity,  :invoiceId,  :sizeDetailId)",
            nativeQuery = true)
    void saveInvoiceDetail(@Param("sellingPrice") Double sellingPrice,
                           @Param("sellingQuantity") Integer sellingQuantity,
                           @Param("invoiceId") Integer invoiceId,
                           @Param("sizeDetailId") Integer sizeDetailId);
}
