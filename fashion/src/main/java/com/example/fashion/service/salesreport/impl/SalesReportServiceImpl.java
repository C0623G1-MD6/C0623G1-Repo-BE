package com.example.fashion.service.salesreport.impl;

import com.example.fashion.dto.salesreport.SalesReport;
import com.example.fashion.repository.reportsales.SalesReportRepository;
import com.example.fashion.service.salesreport.ISalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesReportServiceImpl implements ISalesReportService {
    @Autowired
    private SalesReportRepository salesReportRepository;

    @Override
    public List<SalesReport> getDataDaily(String dateStart,String dateEnd) {
        return salesReportRepository.getDataSpend(dateStart,dateEnd);
    }
}
