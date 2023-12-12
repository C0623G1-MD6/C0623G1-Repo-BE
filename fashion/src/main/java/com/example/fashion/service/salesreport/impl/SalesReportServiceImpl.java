package com.example.fashion.service.salesreport.impl;

import com.example.fashion.repository.reportsales.SalesReportRepository;
import com.example.fashion.service.salesreport.ISalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesReportServiceImpl implements ISalesReportService {
    @Autowired
    private SalesReportRepository salesReportRepository;
}
