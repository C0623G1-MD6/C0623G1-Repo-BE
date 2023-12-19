package com.example.fashion.repository.overview;


import com.example.fashion.dto.overview.ITopFiveSeller;
import com.example.fashion.dto.overview.ITopNewOrder;
import com.example.fashion.model.invoice.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOverviewRepository extends JpaRepository<Invoice, Integer> {

    /**
     * method getTotalProductsSoldWeek
     * Create TruongNQ
     * Date 12-12-2023
     * return list Integer
     */
    @Query(value = "select sum(id.selling_quantity)\n" +
            "from invoices as i\n" +
            "join invoice_details as id\n" +
            "on i.id=id.invoice_id\n" +
            "where week(i.invoice_printing_date)=week(curdate());", nativeQuery = true)
    Integer getTotalProductsSoldWeek();
    /**
     * method getTotalProductsSoldWeek
     * Create TruongNQ
     * Date 12-12-2023
     * return list Integer
     */
    /**
     * method getTotalProductsSoldMonth
     * Create TruongNQ
     * Date 12-12-2023
     * return list Integer
     */
    @Query(value = "select sum(id.selling_quantity)\n" +
            "from invoices as i\n" +
            "join invoice_details as id\n" +
            "on i.id=id.invoice_id\n" +
            "where month(i.invoice_printing_date)=month(curdate());", nativeQuery = true)
    Integer getTotalProductsSoldMonth();

    /**
     * method getTotalProductsSoldYear
     * Create TruongNQ
     * Date 12-12-2023
     * return list Integer
     */
    @Query(value = "select sum(id.selling_quantity)\n" +
            "from invoices as i\n" +
            "join invoice_details as id\n" +
            "on i.id=id.invoice_id\n" +
            "where year(i.invoice_printing_date)=year(curdate());", nativeQuery = true)
    Integer getTotalProductsSoldYear();

    /**
     * method getTotalOrderWeek
     * Create TruongNQ
     * Date 12-12-2023
     * return Integer
     */

    @Query(value = "select count(i.id) from invoices as i where week(i.invoice_printing_date)=week(curdate());", nativeQuery = true)
    Integer getTotalOrderWeek();


    /**
     * method getTotalOrderMonth
     * Create TruongNQ
     * Date 12-12-2023
     * return Integer
     */
    @Query(value = "select count(i.id) from invoices as i where month(i.invoice_printing_date)=month(curdate());", nativeQuery = true)
    Integer getTotalOrderMonth();

    /**
     * method getTotalOrderYear
     * Create TruongNQ
     * Date 12-12-2023
     * return Integer
     */
    @Query(value = "select count(i.id) from invoices as i where year(i.invoice_printing_date)=year(curdate());", nativeQuery = true)
    Integer getTotalOrderYear();

    /**
     * method getTotalRevenueWeek
     * Create TruongNQ
     * Date 12-12-2023
     * return Double
     */
    @Query(value = "select sum(id.selling_price*id.selling_quantity) as revenue\n" +
            "from invoices as i\n" +
            "join invoice_details as id\n" +
            "on i.id=id.invoice_id\n" +
            "where week(i.invoice_printing_date)=week(curdate());", nativeQuery = true)
    Double getTotalRevenueWeek();

    /**
     * method getTotalRevenueMonth
     * Create TruongNQ
     * Date 12-12-2023
     * return Double
     */
    @Query(value = "select sum(id.selling_price*id.selling_quantity) as revenue\n" +
            "from invoices as i\n" +
            "join invoice_details as id\n" +
            "on i.id=id.invoice_id\n" +
            "where month(i.invoice_printing_date)=month(curdate());", nativeQuery = true)
    Double getTotalRevenueMonth();

    /**
     * method getTotalRevenueYear
     * Create TruongNQ
     * Date 12-12-2023
     * return Double
     */
    @Query(value = "select sum(id.selling_price*id.selling_quantity) as revenue\n" +
            "from invoices as i\n" +
            "join invoice_details as id\n" +
            "on i.id=id.invoice_id\n" +
            "where year(i.invoice_printing_date)=year(curdate());", nativeQuery = true)
    Double getTotalRevenueYear();
    /**
     * method getTopFiveSeller
     * Create TruongNQ
     * Date 12-12-2023
     * return list getTopFiveSellerWeek
     */
    @Query(value =
            "select r.employee_id, e.name, sum(r.revenue) as revenue, sum(r.quantity) as quantity\n" +
                    "from (\n" +
                    "\tselect i.id,i.employee_id,  sum(id.selling_quantity * id.selling_price) as revenue, sum(id.selling_quantity) as quantity\n" +
                    "\tfrom invoices as i\n" +
                    "\tjoin invoice_details as id\n" +
                    "\ton i.id=id.invoice_id\n" +
                    "\twhere week(i.invoice_printing_date)=week(curdate())\n" +
                    "\tgroup by i.id\n" +
                    ") as r\n" +
                    "join employees as e\n" +
                    "on r.employee_id=e.id\n" +
                    "group by r.employee_id\n" +
                    "order by revenue desc\n" +
                    "limit 5", nativeQuery = true)
    List<ITopFiveSeller> getTopFiveSellerWeek();
    /**
     * method getTopFiveSeller
     * Create TruongNQ
     * Date 12-12-2023
     * return list getTopFiveSellerMonth
     */
    @Query(value =
            "select r.employee_id, e.name, sum(r.revenue) as revenue, sum(r.quantity) as quantity\n" +
                    "from (\n" +
                    "\tselect i.id,i.employee_id,  sum(id.selling_quantity * id.selling_price) as revenue, sum(id.selling_quantity) as quantity\n" +
                    "\tfrom invoices as i\n" +
                    "\tjoin invoice_details as id\n" +
                    "\ton i.id=id.invoice_id\n" +
                    "\twhere month(i.invoice_printing_date)=month(curdate())\n" +
                    "\tgroup by i.id\n" +
                    ") as r\n" +
                    "join employees as e\n" +
                    "on r.employee_id=e.id\n" +
                    "group by r.employee_id\n" +
                    "order by revenue desc\n" +
                    "limit 5", nativeQuery = true)
    List<ITopFiveSeller> getTopFiveSellerMonth();

    /**
     * method getTopFiveSeller
     * Create TruongNQ
     * Date 12-12-2023
     * return list getTopFiveSellerYear
     */
    @Query(value =
            "select r.employee_id, e.name, sum(r.revenue) as revenue, sum(r.quantity) as quantity\n" +
                    "from (\n" +
                    "\tselect i.id,i.employee_id,  sum(id.selling_quantity * id.selling_price) as revenue, sum(id.selling_quantity) as quantity\n" +
                    "\tfrom invoices as i\n" +
                    "\tjoin invoice_details as id\n" +
                    "\ton i.id=id.invoice_id\n" +
                    "\twhere year(i.invoice_printing_date)=year(curdate())\n" +
                    "\tgroup by i.id\n" +
                    ") as r\n" +
                    "join employees as e\n" +
                    "on r.employee_id=e.id\n" +
                    "group by r.employee_id\n" +
                    "order by revenue desc\n" +
                    "limit 5", nativeQuery = true)
    List<ITopFiveSeller> getTopFiveSellerYear();

    /**
     * method getTopFiveNewOrder
     * Create TruongNQ
     * Date 12-12-2023
     * return list ITopNewOrder
     */
    @Query(value =
            "select c.id,c.name, sum(id.selling_quantity* id.selling_price) as total, i.invoice_printing_date as date\n" +
                    "from invoices as i\n" +
                    "join invoice_details as id\n" +
                    "on i.id=id.invoice_id\n" +
                    "join customers as c\n" +
                    "on i.customer_id=c.id\n" +
                    "group by i.id\n" +
                    "order by i.invoice_printing_date desc\n" +
                    "limit 5;", nativeQuery = true)
    List<ITopNewOrder> getTopFiveNewOrder();


}
