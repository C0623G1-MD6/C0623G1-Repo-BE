package com.example.fashion.controller.overview;
import com.example.fashion.dto.overview.ITopFiveSeller;
import com.example.fashion.dto.overview.ITopNewOrder;
import com.example.fashion.service.overview.IOverviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/overview")
public class OverviewController {
    @Autowired
    IOverviewService service;

    /**
     * method getTotalCustomer
     * Create TruongNQ
     * Date 12-12-2023
     * @param time
     * return Integer
     */
    @GetMapping("/total_customer/{time}")
    public ResponseEntity<Integer> getTotalCustomer(@PathVariable String time) {
        Integer totalCustomer = service.getTotalCustomer(time);
        return new ResponseEntity<>(totalCustomer, HttpStatus.OK);
    }

    /**
     * method getTotalOrder
     * Create TruongNQ
     * Date 12-12-2023
     * @param time
     * return Integer
     */
    @GetMapping("/total_order/{time}")
    public ResponseEntity<Integer> getTotalOrder(@PathVariable String time) {
        Integer totalRevenue = service.getTotalOrder(time);
        return new ResponseEntity<>(totalRevenue, HttpStatus.OK);
    }

    /**
     * method getTotalRevenue
     * Create TruongNQ
     * Date 12-12-2023
     * @param time
     * return Double
     */
    @GetMapping("/revenue/{time}")
    public ResponseEntity<Double> getTotalRevenue(@PathVariable String time) {
        Double totalRevenue = service.getTotalRevenue(time);
        return new ResponseEntity<>(totalRevenue, HttpStatus.OK);
    }

    /**
     * method getTopFiveSeller
     * Create TruongNQ
     * Date 12-12-2023
     * return list iTopFiveSeller
     */
    @GetMapping("/top_seller")
    public ResponseEntity<List<ITopFiveSeller>> getTopFiveSeller() {
        List<ITopFiveSeller> list = service.getTopFiveSeller();
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * method getTopFiveNewOrder
     * Create TruongNQ
     * Date 12-12-2023
     * return list iTopNewOrder
     */
    @GetMapping("/top_new_order")
    public ResponseEntity<List<ITopNewOrder>> getTopFiveNewOrder() {
        List<ITopNewOrder> list = service.getTopFiveNewOrder();
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }








}
