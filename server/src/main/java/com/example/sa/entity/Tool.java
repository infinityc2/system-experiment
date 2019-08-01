package com.example.sa.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tool")
@Data
@Setter @Getter
@NoArgsConstructor
public class Tool{
    @Id
    @GeneratedValue
    private Long toolId;
    private String name;

    @ManyToOne
    private ToolType toolType;
    private float price;

    @ManyToMany(mappedBy = "tool")
    @JsonBackReference
    @Column(nullable = true)
    private Set<RepairInvoice> repairInvoices;

    public Tool(String name, ToolType toolType, float price) {
        this.name = name;
        this.toolType = toolType;
        this.price = price;
    }

}