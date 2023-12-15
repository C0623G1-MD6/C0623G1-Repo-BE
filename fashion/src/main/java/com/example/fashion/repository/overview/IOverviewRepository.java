package com.example.fashion.repository.overview;


import com.example.fashion.dto.overview.ITopFiveSeller;
import com.example.fashion.dto.overview.ITopNewOrder;
import com.example.fashion.model.invoice.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOverviewRepository extends JpaRepository<Invoice, Integer> {

    /**
     * method getTotalCustomerWeek
     * Create TruongNQ
     * Date 12-12-2023
     * return list Integer
     */
    @Query(value = "select distinct i.customer_id from invoices as i where week(i.invoice_printing_date)=week(curdate());", nativeQuery = true)
    List<Integer> getTotalCustomerWeek();

    /**
     * method getTotalCustomerMonth
     * Create TruongNQ
     * Date 12-12-2023
     * return list Interger
     */
    @Query(value = "select distinct i.customer_id from invoices as i where month(i.invoice_printing_date)=month(curdate());", nativeQuery = true)
    List<Integer> getTotalCustomerMonth();

    /**
     * method getTotalCustomerYear
     * Create TruongNQ
     * Date 12-12-2023
     * return list Integer
     */
    @Query(value = "select distinct i.customer_id from invoices as i where year(i.invoice_printing_date)=year(curdate());", nativeQuery = true)
    List<Integer> getTotalCustomerYear();

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
    @Query(value = "select sum(id.selling_quantity * p.price) as revenue\n" +
            "from invoices as i \n" +
            "join invoice_details as id\n" +
            "on i.id=id.invoice_id\n" +
            "join products as p\n" +
            "on id.invoice_id=p.id\n" +
            "where week(i.invoice_printing_date)=week(curdate());", nativeQuery = true)
    Double getTotalRevenueWeek();

    /**
     * method getTotalRevenueMonth
     * Create TruongNQ
     * Date 12-12-2023
     * return Double
     */
    @Query(value = "select sum(id.selling_quantity * p.price) as revenue\n" +
            "from invoices as i \n" +
            "join invoice_details as id\n" +
            "on i.id=id.invoice_id\n" +
            "join products as p\n" +
            "on id.invoice_id=p.id\n" +
            "where month(i.invoice_printing_date)=month(curdate());", nativeQuery = true)
    Double getTotalRevenueMonth();

    /**
     * method getTotalRevenueYear
     * Create TruongNQ
     * Date 12-12-2023
     * return Double
     */
    @Query(value = "select sum(id.selling_quantity * p.price) as revenue\n" +
            "from invoices as i \n" +
            "join invoice_details as id\n" +
            "on i.id=id.invoice_id\n" +
            "join products as p\n" +
            "on id.invoice_id=p.id\n" +
            "where year(i.invoice_printing_date)=year(curdate());", nativeQuery = true)
    Double getTotalRevenueYear();

    /**
     * method getTopFiveSeller
     * Create TruongNQ
     * Date 12-12-2023
     * return list getTopFiveSeller
     */
    @Query(value =
            "select e.id,e.name, sum(id.selling_quantity * p.price) as revenue, sum(id.selling_quantity) as quantity\n" +
                    "from invoices as i \n" +
                    "join invoice_details as id\n" +
                    "on i.id=id.invoice_id\n" +
                    "join products as p\n" +
                    "on id.invoice_id=p.id\n" +
                    "join employees as e\n" +
                    "on i.employee_id = e.id\n" +
                    "group by e.id\n" +
                    "order by sum(id.selling_quantity * p.price) desc\n" +
                    "limit 5;", nativeQuery = true)
    List<ITopFiveSeller> getTopFiveSeller();

    /**
     * method getTopFiveNewOrder
     * Create TruongNQ
     * Date 12-12-2023
     * return list ITopNewOrder
     */
    @Query(value =
            "select i.id, e.name,  id.selling_quantity as total, i.invoice_printing_date as date\n" +
                    "from invoices as i \n" +
                    "join invoice_details as id\n" +
                    "on i.id=id.invoice_id\n" +
                    "join products as p\n" +
                    "on id.invoice_id=p.id\n" +
                    "join employees as e\n" +
                    "on i.employee_id = e.id\n" +
                    "join customers as c\n" +
                    "on i.customer_id=c.id\n" +
                    "order by i.invoice_printing_date desc\n" +
                    "limit 5;", nativeQuery = true)
    List<ITopNewOrder> getTopFiveNewOrder();


}
