package com.example.fashion.dto.invoice;

import com.example.fashion.model.auth.Employee;
import com.example.fashion.model.customer.Customer;
import com.example.fashion.model.invoice.InvoiceDetail;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDateTime;
import java.util.Set;

public class InvoiceDto implements Validator {
    private Integer id;

    private String invoiceCode;

    private LocalDateTime invoicePrintingDate;

    private Customer customer;

    private Employee employee;

    private Set<InvoiceDetail> invoiceDetailSet;

    public InvoiceDto() {
    }

    public InvoiceDto(String invoiceCode, LocalDateTime invoicePrintingDate, Customer customer,
                      Employee employee, Set<InvoiceDetail> invoiceDetailSet) {
        this.invoiceCode = invoiceCode;
        this.invoicePrintingDate = invoicePrintingDate;
        this.customer = customer;
        this.employee = employee;
        this.invoiceDetailSet = invoiceDetailSet;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<InvoiceDetail> getInvoiceDetailSet() {
        return invoiceDetailSet;
    }

    public void setInvoiceDetailSet(Set<InvoiceDetail> invoiceDetailSet) {
        this.invoiceDetailSet = invoiceDetailSet;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        InvoiceDto invoiceDto = (InvoiceDto) target;

    }
}
