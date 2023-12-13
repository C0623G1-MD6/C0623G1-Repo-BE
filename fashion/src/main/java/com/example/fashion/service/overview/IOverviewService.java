package com.example.fashion.service.overview;



import com.example.fashion.dto.overview.ITopFiveSeller;
import com.example.fashion.dto.overview.ITopNewOrder;

import java.util.List;

public interface IOverviewService {
    /**
     * method getTotalCustomer
     * Create TruongNQ
     * Date 12-12-2023
     * @param time
     * return Integer
     */
    Integer getTotalCustomer(String time);
    /**
     * method getTotalOrder
     * Create TruongNQ
     * Date 12-12-2023
     * @param time
     * return Integer
     */
    Integer getTotalOrder(String time);
    /**
     * method getTotalRevenue
     * Create TruongNQ
     * Date 12-12-2023
     * @param time
     * return Double
     */
    Double getTotalRevenue(String time);
    /**
     * method getTopFiveSeller
     * Create TruongNQ
     * Date 12-12-2023
     * return list ITopFiveSeller
     */
    List<ITopFiveSeller> getTopFiveSeller();
    /**
     * method getTopFiveNewOrder
     * Create TruongNQ
     * Date 12-12-2023
     * return list ITopNewOrder
     */
    List<ITopNewOrder> getTopFiveNewOrder();
}
