package com.example.fashion.controller.invoice;

import com.example.fashion.dto.customerDto.ICustomerDto;
import com.example.fashion.dto.invoice.InvoiceDetailDto;
import com.example.fashion.dto.invoice.InvoiceDto;
import com.example.fashion.dto.product.IProductInvoiceDto;
import com.example.fashion.dto.product.ISizeDetailDto;
import com.example.fashion.dto.product.ISizeDto;
import com.example.fashion.model.auth.MyUserDetail;
import com.example.fashion.model.customer.Customer;
import com.example.fashion.service.auth.IEmployeeService;
import com.example.fashion.service.customerService.ICustomerService;
import com.example.fashion.service.impl.MyUserDetailService;
import com.example.fashion.service.invoice.IInvoiceDetailService;
import com.example.fashion.service.invoice.IInvoiceService;
import com.example.fashion.service.product.IProductService;
import com.example.fashion.service.product.ISizeDetailService;
import com.example.fashion.service.product.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Iterator;
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

    @Autowired
    private ISizeService sizeService;

    @Autowired
    private ISizeDetailService sizeDetailService;

    @Autowired
    private IEmployeeService employeeService;
    /**
     * The method help to save invoices, save invoiceDetail, update point customer, update quantity product.
     * @author NhatNk
     * @since 2023-12-12
     * @param invoiceDto is an InvoiceDto object containing invoice information received from FE via an API call
     * @return 200 Ok If save invoice successfully
     * @return 400 Bad Request If save invoice failed
     */
    @PostMapping("/save-invoice")
    public ResponseEntity<Void> saveInvoice(Principal principal, @RequestBody InvoiceDto invoiceDto) {
//        if(bindingResult.hasErrors()){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
        Integer employeeId = Long.valueOf(employeeService.getEmployeeIdByUsername(principal.getName())).intValue();
        invoiceDto.setInvoiceCode(invoiceService.createInvoiceCode());
        invoiceDto.setInvoicePrintingDate(LocalDateTime.now());
        invoiceDto.setEmployeeId(employeeId);
        Boolean statusInvoice = invoiceService.saveInvoice(invoiceDto);
        if (!statusInvoice||invoiceDto.getInvoiceDetailDtoSet().size()==0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            Integer invoiceId = invoiceService.getInvoiceIdByInvoiceCode(invoiceDto.getInvoiceCode());
            Double total = 0.0;
            for (InvoiceDetailDto invoiceDetailDto : invoiceDto.getInvoiceDetailDtoSet()) {
                invoiceDetailDto.setInvoiceId(invoiceId);
                Boolean statusInvoiceDetail = invoiceDetailService.saveInvoiceDetail(invoiceDetailDto);
                {
                    if (!statusInvoiceDetail){
                        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                    } else {
                        sizeDetailService.updateQuantity(invoiceDetailDto.getSellingQuantity(),invoiceDetailDto.getSizeDetailId());
                        total += invoiceDetailDto.getSellingPrice()*invoiceDetailDto.getSellingQuantity();
                    }
                }
            }
            Boolean statusUpdatePoint = customerService.updatePoint(Long.valueOf(Math.round(total/1000)).intValue(),invoiceDto.getCustomerId());
            if (statusUpdatePoint) {
                Customer customer = customerService.findById(invoiceDto.getCustomerId());
                customerService.updateCustomerType(customer.getPoint(), customer.getId());
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
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
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iProductInvoiceDtoList, HttpStatus.OK);
    }

    /**
     * The method help to get info product.
     * @author NhatNk
     * @since 2023-12-14
     * @param productCode is parameter select from product list
     * @return 400 Bad Request If iProductInvoiceDto equal null
     * @return page IProductInvoiceDto and 200 Ok If iProductInvoiceDto is not null
     * @see List<IProductInvoiceDto>
     */
    @GetMapping("/products/{productCode}")
    public ResponseEntity<IProductInvoiceDto> getProductByProductCode(@PathVariable String productCode){
        IProductInvoiceDto iProductInvoiceDto = productService.getProductByProductCode(productCode);
        if (iProductInvoiceDto==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iProductInvoiceDto, HttpStatus.OK);
    }

    /**
     * The method help to get size list of product.
     * @author NhatNk
     * @since 2023-12-15
     * @param productCode is parameter select from product list
     * @return 204 No Content If iSizeDtoList is empty
     * @return iSizeDtoList and 200 Ok If iSizeDtoList is not empty
     * @see List<ISizeDto>
     */
    @GetMapping("/sizes/{productCode}")
    public ResponseEntity<List<ISizeDto>> getListSizeByProductCode(@PathVariable String productCode){
        List<ISizeDto> iSizeDtoList = sizeService.getListSizeByProductCode(productCode);
        if (iSizeDtoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iSizeDtoList,HttpStatus.OK);
    }

    /**
     * The method help to get sizeDetail.
     * @author NhatNk
     * @since 2023-12-15
     * @param productCode is parameter select from product list or scan QR code
     * @param sizeName is parameter select from size list of product
     * @return 204 No Content If iSizeDtoList is null
     * @return iSizeDetailDto and 200 Ok If iSizeDetailDto is not null
     * @see ISizeDetailDto
     */
    @GetMapping("/size-details/{productCode}/{sizeName}")
    public ResponseEntity<ISizeDetailDto> getQuantityByProductCodeAndSizeName(@PathVariable String productCode,
                                                                              @PathVariable String sizeName){
        ISizeDetailDto iSizeDetailDto = sizeDetailService.getQuantityByProductCodeAndSizeName(productCode,sizeName);
        if(iSizeDetailDto==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iSizeDetailDto,HttpStatus.OK);
    }
}
