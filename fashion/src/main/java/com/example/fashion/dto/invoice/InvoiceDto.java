package com.example.fashion.dto.invoice;

import com.example.fashion.dto.customerDto.CustomerDto;
import com.example.fashion.dto.employee.EmployeeDto;
import com.example.fashion.model.auth.Employee;
import com.example.fashion.model.customer.Customer;
import com.example.fashion.model.invoice.InvoiceDetail;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDateTime;
import java.util.Set;

public class InvoiceDto implements Validator{
    private Integer id;

    private String invoiceCode;

    private LocalDateTime invoicePrintingDate;

    private Integer customerId;
    private Integer employeeId;

    public InvoiceDto() {
    }

    public InvoiceDto(Integer id, String invoiceCode, LocalDateTime invoicePrintingDate, Integer customerId, Integer employeeId) {
        this.id = id;
        this.invoiceCode = invoiceCode;
        this.invoicePrintingDate = invoicePrintingDate;
        this.customerId = customerId;
        this.employeeId = employeeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public LocalDateTime getInvoicePrintingDate() {
        return invoicePrintingDate;
    }

    public void setInvoicePrintingDate(LocalDateTime invoicePrintingDate) {
        this.invoicePrintingDate = invoicePrintingDate;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        InvoiceDto  invoiceDto = (InvoiceDto) target;
        if ("".equals(invoiceDto.getInvoiceCode())) {
            errors.rejectValue("invoiceCode", null, "Vui lòng nhập mã hóa đơn");
        }

        if ("".equals(invoiceDto.getInvoicePrintingDate())) {
            errors.rejectValue("invoicePrintingDate", null, "Vui lòng chọn ngày giờ in hóa đơn");
        }

        if ("".equals(invoiceDto.getCustomerId())) {
            errors.rejectValue("customerId", null, "Vui lòng chọn khách hàng");
        }

        if ("".equals(invoiceDto.getEmployeeId())) {
            errors.rejectValue("employeeId", null, "Vui lòng chọn nhân viên");
        }
    }

}
