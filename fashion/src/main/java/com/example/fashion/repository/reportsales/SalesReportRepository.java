package com.example.fashion.repository.reportsales;

import com.example.fashion.dto.salesreport.SalesReport;

import com.example.fashion.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface SalesReportRepository extends JpaRepository<Product, Integer> {
    /**
     * @author: LamTV
     * @date: 13/12/2023
     * @param startDate date start
     * @param endDate date end
     * @return List<SalesReport>
     * @method getData()
     */
    @Query(value = "WITH RECURSIVE DateRange AS (SELECT :startDate AS `date` \n" +
            " UNION ALL SELECT DATE_ADD(`date`, INTERVAL 1 DAY) \n" +
            " FROM DateRange WHERE DATE_ADD(`date`, INTERVAL 1 DAY) <= :endDate) \n" +
            " SELECT dr.`date` AS `date`, COALESCE(SUM(iv.selling_quantity*p.price), 0) AS `revenue`,\n" +
            " COALESCE(SUM(wrd.input_price*wrd.input_quantity), 0) AS `spend` \n" +
            " FROM DateRange dr \n" +
            " LEFT JOIN invoices i ON DATE(dr.`date`) = DATE(i.invoice_printing_date) \n" +
            " LEFT JOIN invoice_details iv ON iv.invoice_id = i.id \n" +
            " LEFT JOIN size_details s ON s.id = iv.size_detail_id\n" +
            " LEFT JOIN products p ON p.id = s.product_id\n" +
            " LEFT JOIN warehouse_receipt_details wrd ON wrd.size_detail_id = s.id\n" +
            " LEFT JOIN warehouse_receipts wr ON wr.id = wrd.warehouse_receipt_id\n" +
            " GROUP BY dr.`date` \n" +
            " UNION SELECT dr.`date` AS `date`, \n" +
            "\t0 AS `revenue`, \n" +
            "\t0 AS `spend`\n" +
            " FROM DateRange dr ORDER BY `date`", nativeQuery = true)
    List<SalesReport> getDataSpend(String startDate, String endDate);

}
