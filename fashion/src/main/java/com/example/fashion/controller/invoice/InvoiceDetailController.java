package com.example.fashion.controller.invoice;

import com.example.fashion.dto.invoice.InvoiceDetailDto;
import com.example.fashion.model.invoice.InvoiceDetail;
import com.example.fashion.service.invoice.IInvoiceDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/invoice-details")
public class InvoiceDetailController {
    @Autowired
    private IInvoiceDetailService invoiceDetailService;

    @PostMapping
    public ResponseEntity<Void> saveInvoiceDetail(@RequestBody InvoiceDetailDto invoiceDetailDto){
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        BeanUtils.copyProperties(invoiceDetailDto, invoiceDetail);
        Boolean status = invoiceDetailService.saveInvoiceDetail(invoiceDetail);
        if (!status){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
