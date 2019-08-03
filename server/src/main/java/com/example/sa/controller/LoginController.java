package com.example.sa.controller;

import java.util.Map;

import com.example.sa.entity.Customer;
import com.example.sa.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class LoginController {

    @Autowired private CustomerRepository customerRepository;

    @PostMapping
    public Boolean login(@RequestBody Map<String, String> body) {
        Customer customer = customerRepository.findByUsername(body.get("username"));

        try {
            if (customer.getPassword().equals(body.get("password"))) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }
}