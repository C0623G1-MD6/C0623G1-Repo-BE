package com.example.fashion.service.salesreport;

import com.example.fashion.dto.salesreport.SalesReport;

import java.util.List;

public interface ISalesReportService {
    List<SalesReport> getDataDaily(String dateStart, String dateEnd);
    List<SalesReport> getDataSpend(String dateStart, String dateEnd);
    List<SalesReport> getDataRevenue(String dateStart, String dateEnd);
}
