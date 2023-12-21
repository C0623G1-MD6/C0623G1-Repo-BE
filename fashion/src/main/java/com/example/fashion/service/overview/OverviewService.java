package com.example.fashion.service.overview;
import com.example.fashion.dto.overview.ITopFiveSeller;
import com.example.fashion.dto.overview.ITopNewOrder;
import com.example.fashion.repository.overview.IOverviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OverviewService implements IOverviewService{
    @Autowired
    private IOverviewRepository repository;
    /**
     * method getTotalCustomer
     * Create TruongNQ
     * Date 12-12-2023
     * @param time
     * return Integer
     */

    @Override
    public Integer getTotalCustomer(String time) {
        Integer result=0;
        switch (time){
            case "week":
                result=repository.getTotalProductsSoldWeek();
                break;
            case "month":
                result=repository.getTotalProductsSoldMonth();
                break;
            case "year":
                result=repository.getTotalProductsSoldYear();
                break;
            default:
                result=0;
        }
        return result;
    }
    /**
     * method getTotalOrder
     * Create TruongNQ
     * Date 12-12-2023
     * @param time
     * return Integer
     */
    @Override
    public Integer getTotalOrder(String time) {
        Integer result=0;
        switch (time){
            case "week":
                result=repository.getTotalOrderWeek();
                break;
            case "month":
                result=repository.getTotalOrderMonth();
                break;
            case "year":
                result=repository.getTotalOrderYear();
                break;
            default:
                result=0;
        }
        return result;
    }
    /**
     * method getTotalRevenue
     * Create TruongNQ
     * Date 12-12-2023
     * @param time
     * return Double
     */

    @Override
    public Double getTotalRevenue(String time) {
        Double result = 0.0d;
        switch (time){
            case "week":
                result=repository.getTotalRevenueWeek();
                break;
            case "month":
                result=repository.getTotalRevenueMonth();
                break;
            case "year":
                result=repository.getTotalRevenueYear();
                break;
            default:
                result=0.0d;
        }
        return result;
    }

    @Override
    public List<ITopFiveSeller> getTopFiveSeller(String time) {
        List<ITopFiveSeller> list;
        switch (time) {
            case "week":
                list=repository.getTopFiveSellerWeek();
                break;
            case "month":
                list=repository.getTopFiveSellerMonth();
                break;
            case "year":
                list=repository.getTopFiveSellerYear();
                break;
            default:
                list=new ArrayList<>();
        }
        return list;
    }

    /**
     * method getTopFiveSeller
     * Create TruongNQ
     * Date 12-12-2023
     * return list iTopFiveSeller
     */


    @Override
    public List<ITopNewOrder> getTopFiveNewOrder() {
        return repository.getTopFiveNewOrder();
    }
}
