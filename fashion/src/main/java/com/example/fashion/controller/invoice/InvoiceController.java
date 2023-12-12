package com.example.fashion.controller.invoice;

import com.example.fashion.dto.invoice.InvoiceDto;
import com.example.fashion.model.invoice.Invoice;
import com.example.fashion.service.invoice.IInvoiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class InvoiceController {
    @Autowired
    private IInvoiceService invoiceService;

    /**
     * method saveInvoice
     * create by NhatNK
     * date 12/12/2023
     * return ResponseEntity
     */
    @PostMapping
    public ResponseEntity<String> saveInvoice(@RequestBody InvoiceDto invoiceDto){
        Invoice invoice = new Invoice();
        BeanUtils.copyProperties(invoiceDto, invoice);
        Boolean status = invoiceService.saveInvoice(invoice);
        if(!status){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
