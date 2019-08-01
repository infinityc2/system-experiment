package com.example.sa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@NoArgsConstructor
@Setter @Getter
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue
    private Long customerId;

    @NotNull
    @Column(unique = true)
    private String username;
    @NotNull
    private String password;

    public Customer(String username, String password) {
       this.username = username;
       this.password = password;
    }

    
}