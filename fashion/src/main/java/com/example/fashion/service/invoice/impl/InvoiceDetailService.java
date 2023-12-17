package com.example.fashion.service.invoice.impl;

import com.example.fashion.dto.invoice.InvoiceDetailDto;
import com.example.fashion.repository.invoice.IInvoiceDetailRepository;
import com.example.fashion.service.invoice.IInvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceDetailService implements IInvoiceDetailService {
    @Autowired
    private IInvoiceDetailRepository invoiceDetailRepository;

    /**
     * The method help to save invoice detail.
     * @author NhatNk
     * @since 2023-12-14
     * @param invoiceDetailDto is an object containing invoiceDetailDto information
     * @return 200 Ok If no exception occurs
     * @return 400 Bad Request If an exception occurs
     */
    @Override
    public Boolean saveInvoiceDetail(InvoiceDetailDto invoiceDetailDto) {
        try {
            invoiceDetailRepository.saveInvoiceDetail(invoiceDetailDto.getSellingQuantity(), invoiceDetailDto.getInvoiceId(),
                    invoiceDetailDto.getSizeDetailId());
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
