package com.example.sa.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import com.example.sa.entity.Brand;
import com.example.sa.entity.ComputerType;
import com.example.sa.entity.Customer;
import com.example.sa.entity.RepairInvoice;
import com.example.sa.repository.BrandRepository;
import com.example.sa.repository.ComputerTypeRepository;
import com.example.sa.repository.CustomerRepository;
import com.example.sa.repository.RepairInvoiceRepository;
import com.example.sa.repository.ToolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoice")
public class RepairInvoiceController {

    @Autowired private RepairInvoiceRepository repairInvoiceRepository;
    @Autowired private ComputerTypeRepository computerTypeRepository;
    @Autowired private BrandRepository brandRepository;
    @Autowired private ToolRepository toolRepository;
    @Autowired private CustomerRepository customerRepository;

    @GetMapping("/{id}")
    public Optional<RepairInvoice> repairInvoice(@PathVariable Long id) {
        return repairInvoiceRepository.findById(id);
    }

    // @PostMapping("/invoice")
    // public RepairInvoice addInvoice(@RequestBody Map<String, Object> body) {
    //     RepairInvoice newInvoice = new RepairInvoice();
    //     SimpleDateFormat date = new SimpleDateFormat("EEE, MMM d, ''yy");
    //     Optional<Brand> brand = brandRepository.findById(Long.valueOf(body.get("brandId").toString()));
    //     Optional<ComputerType> computerType = computerTypeRepository.findById(Long.valueOf(body.get("computerTypeId").toString()));
    //     Optional<Customer> customer = customerRepository.findById(Long.valueOf(body.get("customerId").toString()));

    //     newInvoice.setCustomer(customer.get());
    //     newInvoice.setComputerType(computerType.get());
    //     newInvoice.setBrand(brand.get());
    //     newInvoice.setPhoneNumber(body.get("phoneNumber").toString());
    //     newInvoice.setEmail(body.get("email").toString());
    //     newInvoice.setDescribe(body.get("describe").toString());
        

    //     try {
    //         newInvoice.setCurDate(new Date());
    //         newInvoice.setSentDate(date.parse(body.get("sentDate").toString()));
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //     }
        

    //     return repairInvoiceRepository.save(newInvoice);
    // }

}