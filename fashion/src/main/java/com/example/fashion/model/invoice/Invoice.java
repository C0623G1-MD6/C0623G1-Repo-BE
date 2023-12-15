package com.example.fashion.model.invoice;

import com.example.fashion.model.auth.Employee;
import com.example.fashion.model.customer.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "invoice_code",nullable = false, unique = true, columnDefinition = "varchar(50)")
    private String invoiceCode;


    @Column(name = "invoice_printing_date", nullable = false, columnDefinition = "datetime")
    private LocalDateTime invoicePrintingDate;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @JsonBackReference
    @OneToMany(mappedBy = "invoice")
    private Set<InvoiceDetail> invoiceDetailSet;

    public Invoice() {
    }

    public Invoice(String invoiceCode, LocalDateTime invoicePrintingDate, Customer customer, Employee employee,
                   Set<InvoiceDetail> invoiceDetailSet) {
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
}
