package com.example.sa.dataloader;

import com.example.sa.entity.Customer;
import com.example.sa.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataloader implements ApplicationRunner {

    @Autowired private CustomerRepository customerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Customer customer1 = new Customer("test1", "test");
        customerRepository.save(customer1);
	}

    
}