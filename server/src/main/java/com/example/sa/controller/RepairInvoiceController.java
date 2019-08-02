package com.example.sa.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.example.sa.entity.Brand;
import com.example.sa.entity.ComputerType;
import com.example.sa.entity.Customer;
import com.example.sa.entity.RepairInvoice;
import com.example.sa.entity.Tool;
import com.example.sa.repository.BrandRepository;
import com.example.sa.repository.ComputerTypeRepository;
import com.example.sa.repository.CustomerRepository;
import com.example.sa.repository.RepairInvoiceRepository;
import com.example.sa.repository.ToolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoices")
@CrossOrigin(origins = "*")
public class RepairInvoiceController {

    @Autowired private RepairInvoiceRepository repairInvoiceRepository;
    @Autowired private ComputerTypeRepository computerTypeRepository;
    @Autowired private BrandRepository brandRepository;
    @Autowired private ToolRepository toolRepository;
    @Autowired private CustomerRepository customerRepository;


    @GetMapping("/")
    public List<RepairInvoice> getAllRepairInvoice() {
        return repairInvoiceRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<RepairInvoice> getOneRepairInvoice(@PathVariable Long id) {
        return repairInvoiceRepository.findById(id);
    }

    @PostMapping("/invoice/{items}")
    public RepairInvoice addRepairInvoice(@PathVariable List<Long> items, @RequestBody Map<String, String> body) {
        RepairInvoice newInvoice = new RepairInvoice();
        Optional<Brand> brand = brandRepository.findById(Long.valueOf(body.get("brand").toString()));
        Optional<ComputerType> computerType = computerTypeRepository.findById(Long.valueOf(body.get("computerType").toString()));
        // Optional<Customer> customer = customerRepository.findById(Long.valueOf(body.get("customer").toString()));

        newInvoice.setEmail(body.get("email").toString());
        newInvoice.setBrand(brand.get());
        newInvoice.setComputerType(computerType.get());
        newInvoice.setDescribe(body.get("describe").toString());
        // newInvoice.setCustomer(customer.get());
        newInvoice.setPhoneNumber(body.get("phoneNumber").toString());
        newInvoice.setCurDate(new Date());
        
        Set<Tool> tools = new HashSet<Tool>();
        for(Long i: items) {
            Tool tool = toolRepository.findById(i).get();
            tools.add(tool);
        }
        newInvoice.setTool(tools);

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = dateFormat.parse((String) body.get("sentDate"));
            Timestamp date = new java.sql.Timestamp(parsedDate.getTime());
            newInvoice.setSentDate(date);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        

        return repairInvoiceRepository.save(newInvoice);
    }

}