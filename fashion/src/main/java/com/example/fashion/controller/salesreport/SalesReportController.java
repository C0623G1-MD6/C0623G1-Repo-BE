package com.example.fashion.controller.salesreport;

import com.example.fashion.dto.salesreport.SalesReport;
import com.example.fashion.service.salesreport.ISalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/sales-report/")
public class SalesReportController {
    @Autowired
    private ISalesReportService salesReportService;
    @GetMapping("/statistical")
    public ResponseEntity<?> getSalesReport(@RequestParam("startDate") String startDate,
                                            @RequestParam("endDate") String endDate) {
        List<SalesReport> data = salesReportService.getDataDaily(startDate,endDate);
        return ResponseEntity.ok(data);
    }
    @GetMapping("/spend")
    public ResponseEntity<?> getSpend(@RequestParam("startDate") String startDate,
                                            @RequestParam("endDate") String endDate) {
        List<SalesReport> data = salesReportService.getDataSpend(startDate,endDate);
        return ResponseEntity.ok(data);
    }
    @GetMapping("/revenue")
    public ResponseEntity<?> getRevenue(@RequestParam("startDate") String startDate,
                                            @RequestParam("endDate") String endDate) {
        List<SalesReport> data = salesReportService.getDataRevenue(startDate,endDate);
        return ResponseEntity.ok(data);
    }
}
