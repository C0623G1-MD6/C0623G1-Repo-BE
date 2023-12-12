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
    @Query(value = "select distinct i.id_customer from invoice as i where week(i.invoice_printing_date)=week(curdate());", nativeQuery = true)
    List<Integer> getTotalCustomerWeek();

    /**
     * method getTotalOrderWeek
     * Create TruongNQ
     * Date 12-12-2023
     * return Integer
     */
    @Query(value = "select count(i.id) from invoice as i where week(i.invoice_printing_date)=week(curdate());", nativeQuery = true)
    Integer getTotalOrderWeek();

    /**
     * method getTotalRevenueWeek
     * Create TruongNQ
     * Date 12-12-2023
     * return Double
     */
    @Query(value = "select sum(total_payment) from invoice as i where week(i.invoice_printing_date)=week(curdate());", nativeQuery = true)
    Double getTotalRevenueWeek();

    /**
     * method getTotalCustomerMonth
     * Create TruongNQ
     * Date 12-12-2023
     * return list Interger
     */
    @Query(value = "select distinct i.id_customer from invoice as i where month(i.invoice_printing_date)=month(curdate());", nativeQuery = true)
    List<Integer> getTotalCustomerMonth();

    /**
     * method getTotalOrderMonth
     * Create TruongNQ
     * Date 12-12-2023
     * return Integer
     */
    @Query(value = "select count(i.id) from invoice as i where month(i.invoice_printing_date)=month(curdate());", nativeQuery = true)
    Integer getTotalOrderMonth();

    /**
     * method getTotalRevenueMonth
     * Create TruongNQ
     * Date 12-12-2023
     * return Double
     */
    @Query(value = "select sum(total_payment) from invoice as i where month(i.invoice_printing_date)=month(curdate());", nativeQuery = true)
    Double getTotalRevenueMonth();

    /**
     * method getTotalCustomerYear
     * Create TruongNQ
     * Date 12-12-2023
     * return list Integer
     */
    @Query(value = "select distinct i.id_customer from invoice as i where year(i.invoice_printing_date)=year(curdate());", nativeQuery = true)
    List<Integer> getTotalCustomerYear();

    /**
     * method getTotalOrderYear
     * Create TruongNQ
     * Date 12-12-2023
     * return Integer
     */
    @Query(value = "select count(i.id) from invoice as i where year(i.invoice_printing_date)=year(curdate());", nativeQuery = true)
    Integer getTotalOrderYear();

    /**
     * method getTotalRevenueYear
     * Create TruongNQ
     * Date 12-12-2023
     * return Double
     */
    @Query(value = "select sum(total_payment) from invoice as i where year(i.invoice_printing_date)=year(curdate());", nativeQuery = true)
    Double getTotalRevenueYear();

    /**
     * method getTopFiveSeller
     * Create TruongNQ
     * Date 12-12-2023
     * return list getTopFiveSeller
     */
    @Query(value =
            "select e.id, e.name, sum(i.total_payment) as revenue, count(i.id) as quantity\n" +
                    "from invoice as i\n" +
                    "join employee as e\n" +
                    "on i.id_employee=e.id\n" +
                    "group by e.id\n" +
                    "order by sum(i.total_payment) desc\n" +
                    "limit 5;", nativeQuery = true)
    List<ITopFiveSeller> getTopFiveSeller();

    /**
     * method getTopFiveNewOrder
     * Create TruongNQ
     * Date 12-12-2023
     * return list ITopNewOrder
     */
    @Query(value =
            "select i.id,c.name as name, i.total_payment as total, i.date\n" +
                    "from invoice as i\n" +
                    "join customer as c\n" +
                    "on i.id_employee=c.id\n" +
                    "order by i.invoice_printing_date desc\n" +
                    "limit 5;", nativeQuery = true)
    List<ITopNewOrder> getTopFiveNewOrder();


}
