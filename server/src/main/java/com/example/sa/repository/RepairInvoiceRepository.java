package com.example.sa.repository;

import com.example.sa.entity.RepairInvoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RepairInvoiceRepository extends JpaRepository<RepairInvoice, Long> {

    
}