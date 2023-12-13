package com.example.fashion.controller.invoice;

import com.example.fashion.dto.customerDto.ICustomerDto;
import com.example.fashion.dto.invoice.InvoiceDto;
import com.example.fashion.model.customer.Customer;
import com.example.fashion.model.invoice.Invoice;
import com.example.fashion.service.customerService.ICustomerService;
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

    @Autowired
    private ICustomerService customerService;

    /**
     * The method help to save invoices.
     * @author NhatNk
     * @since 2023-12-12
     * @param invoiceDto is an InvoiceDto object containing invoice information received from FE via an API call
     * @return 200 Ok If save invoice successfully
     * @return 400 Bad Request If save invoice failed
     */
    @PostMapping
    public ResponseEntity<Void> saveInvoice(@RequestBody InvoiceDto invoiceDto) {
        Invoice invoice = new Invoice();
        BeanUtils.copyProperties(invoiceDto, invoice);
        Boolean status = invoiceService.saveInvoice(invoice);
        if (!status) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * The method help to get page customer.
     * @author NhatNk
     * @since 2023-12-13
     * @param page is the page number to display
     * @param keyword is String entered from input box on the screen
     * @return 400 Bad Request If customer page equal null
     * @return page iCustomerDto and 200 Ok If save invoice successfully
     * @see Page<ICustomerDto>
     */
    @GetMapping("/customers")
    public ResponseEntity<Page<ICustomerDto>> getAllCustomer(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                             @RequestParam(value = "keyword", defaultValue = "", required = false) String keyword) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<ICustomerDto> iCustomerDtoPage = customerService.getAllCustomer(pageable, keyword);
        if (iCustomerDtoPage == null||iCustomerDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iCustomerDtoPage, HttpStatus.OK);
    }
}
