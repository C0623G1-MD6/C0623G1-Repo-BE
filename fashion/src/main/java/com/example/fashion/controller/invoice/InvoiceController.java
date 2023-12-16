package com.example.fashion.controller.invoice;

import com.example.fashion.dto.customerDto.ICustomerDto;
import com.example.fashion.dto.invoice.InvoiceDetailDto;
import com.example.fashion.dto.invoice.InvoiceDto;
import com.example.fashion.dto.product.IProductInvoiceDto;
import com.example.fashion.service.customerService.ICustomerService;
import com.example.fashion.service.invoice.IInvoiceDetailService;
import com.example.fashion.service.invoice.IInvoiceService;
import com.example.fashion.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
    @Autowired
    private IInvoiceService invoiceService;

    @Autowired
    private IInvoiceDetailService invoiceDetailService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProductService productService;

    /**
     * The method help to save invoices.
     * @author NhatNk
     * @since 2023-12-12
     * @param invoiceDto is an InvoiceDto object containing invoice information received from FE via an API call
     * @return 200 Ok If save invoice successfully
     * @return 400 Bad Request If save invoice failed
     */
    @PostMapping("/save-invoice")
    public ResponseEntity<Void> saveInvoice(@RequestBody InvoiceDto invoiceDto, BindingResult bindingResult) {
        new InvoiceDto().validate(invoiceDto,bindingResult);
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Boolean status = invoiceService.saveInvoice(invoiceDto);
        if (!status) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * The method help to save invoice detail.
     * @author NhatNk
     * @since 2023-12-13
     * @param invoiceDetailDto is an InvoiceDetailDto object containing invoiceDetail information received from FE via an API call
     * @return 200 Ok If save invoiceDetail successfully
     * @return 400 Bad Request If save invoiceDetail failed
     */
    @PostMapping("/save-invoice-detail")
    public ResponseEntity<Void> saveInvoiceDetail(@RequestBody InvoiceDetailDto invoiceDetailDto, BindingResult bindingResult){
        new InvoiceDetailDto().validate(invoiceDetailDto,bindingResult);
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Boolean status = invoiceDetailService.saveInvoiceDetail(invoiceDetailDto);
        if (!status){
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
     * @return 400 Bad Request If iCustomerDtoPage equal null or is empty
     * @return page iCustomerDto and 200 Ok If iCustomerDtoPage is not null or is not empty
     * @see Page<ICustomerDto>
     */
    @GetMapping("/customers")
    public ResponseEntity<Page<ICustomerDto>> getAllCustomer(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                             @RequestParam(value = "keyword", defaultValue = "", required = false) String keyword) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<ICustomerDto> iCustomerDtoPage = customerService.getAllCustomer(pageable, keyword);
        if (iCustomerDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iCustomerDtoPage, HttpStatus.OK);
    }


    /**
     * The method help to get list product.
     * @author NhatNk
     * @since 2023-12-14
     * @param keyword is String entered from input box on the screen
     * @return 400 Bad Request If iProductInvoiceDtoList equal null or is empty
     * @return page IProductInvoiceDto and 200 Ok If IProductInvoiceDto is not null or is not empty
     * @see List<IProductInvoiceDto>
     */
    @GetMapping("/products")
    public ResponseEntity<List<IProductInvoiceDto>> getListProduct(@RequestParam(value = "keyword", defaultValue = "", required = false) String keyword) {
        List<IProductInvoiceDto> iProductInvoiceDtoList = productService.getListProduct(keyword);
        if (iProductInvoiceDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iProductInvoiceDtoList, HttpStatus.OK);
    }

    /**
     * The method help to get info product.
     * @author NhatNk
     * @since 2023-12-14
     * @param productCode s parameter select from List Product
     * @return 400 Bad Request If iProductInvoiceDto equal null
     * @return page IProductInvoiceDto and 200 Ok If iProductInvoiceDto is not null
     * @see List<IProductInvoiceDto>
     */
    @GetMapping("/products/{productCode}")
    public ResponseEntity<IProductInvoiceDto> getProductByProductCode(@PathVariable String productCode){
        IProductInvoiceDto iProductInvoiceDto = productService.getProductByProductCode(productCode);
        if (iProductInvoiceDto==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iProductInvoiceDto, HttpStatus.OK);
    }


}
