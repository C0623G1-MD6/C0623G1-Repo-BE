package com.example.fashion.repository.reportsales;

import com.example.fashion.dto.salesreport.SalesReport;
import com.example.fashion.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalesReportRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select iv.invoice_printing_date,wr.receipt_date " +
            " from products pr " +
            " join invoice_details ids on pr.id = ids.product_id " +
            " join invoices iv on iv.id = ids.invoice_id " +
            " join warehouse_receipt_details wrd on wrd.product_id = pr.id " +
            " join warehouse_receipt wr on wr.id = wrd.warehouse_receipt_id",nativeQuery = true)
    List<SalesReport> getDataSales();
}
