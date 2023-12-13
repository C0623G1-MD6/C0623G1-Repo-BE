package com.example.fashion.controller.invoice;

import com.example.fashion.dto.invoice.InvoiceDto;
import com.example.fashion.model.customer.Customer;
import com.example.fashion.model.invoice.Invoice;
import com.example.fashion.service.invoice.IInvoiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/invoices")
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

    @GetMapping("/customers")
    public ResponseEntity<Page<Customer>> getAllCustomer(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                         @RequestParam (value = "keyword", defaultValue = "", required = false) String keyword){
        Pageable pageable = PageRequest.of(page,5);
        Page<Customer> customerPage = invoiceService.getAllCustomer(pageable, keyword);
        if(customerPage==null){
            return new  ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customerPage,HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<Page<Invoice>> getAllInvoice(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                         @RequestParam (value = "keyword", defaultValue = "", required = false) String keyword){
        Pageable pageable = PageRequest.of(page,5);
        Page<Invoice> invoicePage = invoiceService.getAllInvoice(pageable, keyword);
        if(invoicePage==null){
            return new  ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(invoicePage,HttpStatus.OK);
    }
}
