package com.example.fashion.controller.salesreport;

import com.example.fashion.service.salesreport.ISalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/sales-report/")
public class SalesReportController {
    @Autowired
    private ISalesReportService salesReportService;
}
