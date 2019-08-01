package com.example.sa.dataloader;

import java.util.stream.Stream;

import com.example.sa.entity.Brand;
import com.example.sa.repository.BrandRepository;
import com.example.sa.repository.ToolTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class BrandDataloader implements ApplicationRunner {

    @Autowired private BrandRepository brandRepository; 

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of("Lenovo", "HP", "Dell", "Apple", "Asus", "Acer", "Sony", "Alienware", "Samsung", "Toshiba", "Microsoft", "Compaq", "MSI").forEach(b -> {
            Brand brand = new Brand();
            brand.setName(b);
            brandRepository.save(brand);
        });
    }
}