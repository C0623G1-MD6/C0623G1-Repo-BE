package com.example.fashion.service.salesreport.impl;

import com.example.fashion.dto.salesreport.SalesReport;
import com.example.fashion.repository.reportsales.SalesReportRepository;
import com.example.fashion.service.salesreport.ISalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SalesReportServiceImpl implements ISalesReportService {
    @Autowired
    private SalesReportRepository salesReportRepository;

    @Override
    public List<SalesReport> getDataDaily(String dateStart, String dateEnd) {
        return salesReportRepository.getDataSpendAndRevenue(dateStart,dateEnd);
    }
    @Transactional
    @Override
    public List<SalesReport> getDataSpend(String dateStart, String dateEnd) {
        try{
            return salesReportRepository.getDataSpend(dateStart, dateEnd);

        }catch (Exception e){
            return null;
        }
    }
    @Transactional
    @Override
    public List<SalesReport> getDataRevenue(String dateStart, String dateEnd) {
        try{
            return salesReportRepository.getDataRevenue(dateStart, dateEnd);

        }catch (Exception e){
            return null;
        }
    }
    @Transactional
    @Override
    public SalesReport getRevenueOfMonth(String month) {
        try{
            return salesReportRepository.getRevenueOfMonth(month);

        }catch (Exception e){
            return null;
        }
    }
    @Transactional
    @Override
    public SalesReport getSpendOfMonth(int month) {
        try{
            return salesReportRepository.getSpendOfMonth(month);

        }catch (Exception e){
            return null;
        }
    }
}
