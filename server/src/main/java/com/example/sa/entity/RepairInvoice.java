package com.example.sa.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
@Table(name = "repair_invoice")
@NoArgsConstructor
@Setter @Getter
public class RepairInvoice {

    @Id
    @GeneratedValue
    private Long invoiceId;

    @ManyToOne
    private ComputerType computerType;
    @ManyToOne
    private Brand brand;
    

    @NotNull
    private String phoneNumber;
    @NotNull
    private String email;
    private Date curDate;
    private Date sentDate;
    
    @Column(nullable = true)
    private Date receiveDate;

    private String describe;

    @ManyToMany
    @Column(name = "tool_id",nullable = true)
    @JoinTable(
        name = "tool_invoice",
        joinColumns = @JoinColumn(name = "invoice_id", referencedColumnName = "invoiceId"),
        inverseJoinColumns = @JoinColumn(name = "tool_id", referencedColumnName = "toolId"))
    private Set<Tool> tool;

    @ManyToOne
    private Customer customer;
    // Date Format
    // "EEE, MMM d, ''yy"

}