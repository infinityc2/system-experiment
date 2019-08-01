package com.example.sa.dataloader;

import java.util.stream.Stream;

import com.example.sa.entity.Brand;
import com.example.sa.entity.ComputerType;
import com.example.sa.repository.ComputerTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ComputerTypeDataloader implements ApplicationRunner {

    @Autowired private ComputerTypeRepository computerTypeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of("PC", "Laptop").forEach(type -> {
            ComputerType computerType = new ComputerType();
            computerType.setType(type);
            computerTypeRepository.save(computerType);
        });
    }
}