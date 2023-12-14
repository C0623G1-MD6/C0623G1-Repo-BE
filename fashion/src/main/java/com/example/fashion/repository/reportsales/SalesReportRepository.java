package com.example.fashion.repository.reportsales;

import com.example.fashion.dto.salesreport.SalesReport;

import com.example.fashion.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalesReportRepository extends JpaRepository<Product, Integer> {
    @Query(value = "WITH RECURSIVE DateRange AS (" +
            "  SELECT :startDate AS `date` " +
            "  UNION ALL " +
            "  SELECT DATE_ADD(`date`, INTERVAL 1 DAY) " +
            "  FROM DateRange " +
            "  WHERE DATE_ADD(`date`, INTERVAL 1 DAY) <= :endDate" +
            ") " +
            "SELECT " +
            "  dr.`date` AS `date`, " +
            "  COALESCE(SUM(wrd.input_price * wrd.input_quantity), 0) AS `spend` " +
            "FROM DateRange dr " +
            "LEFT JOIN warehouse_receipts wr ON DATE(dr.`date`) = DATE(wr.receipt_date) " +
            "LEFT JOIN warehouse_receipt_details wrd ON wrd.warehouse_receipt_id = wr.id " +
            "LEFT JOIN products p ON wrd.product_id = p.id " +
            "GROUP BY dr.`date` " +
            "UNION " +
            "SELECT " +
            "  dr.`date` AS `date`, " +
            "  0 AS `spend` " +
            "FROM DateRange dr " +
            "ORDER BY `date`;", nativeQuery = true)
    List<SalesReport> getDataSpend(String startDate, String endDate);

    @Query(value = "WITH RECURSIVE DateRange AS ("
            + "SELECT :startDate AS `date` "
            + "UNION ALL "
            + "SELECT DATE_ADD(`date`, INTERVAL 1 DAY) "
            + "FROM DateRange "
            + "WHERE DATE_ADD(`date`, INTERVAL 1 DAY) <= :endDate "
            + ")"
            + "SELECT "
            + "dr.`date` AS `date`, "
            + "COALESCE(SUM(((ivd.selling_quantity * ivd.selling_price))), 0) AS `revenue`, "
            + "COALESCE(SUM(wrd.input_price*wrd.input_quantity), 0) AS `spend` "
            + "FROM DateRange dr "
            + "LEFT JOIN invoices ivo ON dr.`date` = ivo.invoice_printing_date "
            + "LEFT JOIN invoice_details ivd ON ivd.invoice_id = ivo.id "
            + "LEFT JOIN products p ON ivd.product_id = p.id "
            + "LEFT JOIN warehouse_receipt_details wrd on wrd.product_id = p.id "
            + "LEFT JOIN  warehouse_receipts wr on wr.id = wrd.warehouse_receipt_id "
            + "GROUP BY dr.`date` "
            + "ORDER BY `date`", nativeQuery = true)
    List<SalesReport> getData(String startDate, String endDate);
}
