package com.example.sa.dataloader;

import java.util.Optional;
import java.util.stream.Stream;

import com.example.sa.entity.Tool;
import com.example.sa.entity.ToolType;
import com.example.sa.repository.ToolRepository;
import com.example.sa.repository.ToolTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ToolDataloader implements ApplicationRunner {

    @Autowired
    private ToolRepository toolRepository;
    @Autowired
    private ToolTypeRepository toolTypeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of("Hardware", "Software").forEach(type -> {
            ToolType toolType = new ToolType();
            toolType.setName(type);
            toolTypeRepository.save(toolType);
        });
        Optional<ToolType> hardware = toolTypeRepository.findById(1L);
        Optional<ToolType> software = toolTypeRepository.findById(2L);

        Tool software1 = new Tool("Windows 10", software.get(), 5000);
        Tool software2 = new Tool("Microsoft Office", software.get(), 3000);
        Tool software3 = new Tool("Steam", software.get(), 0);
        Tool software4 = new Tool("Discord", software.get(), 0);
        Tool software5 = new Tool("Chrome", software.get(), 0);
        Tool software6 = new Tool("Dropbox", software.get(), 0);
        Tool software7 = new Tool("Sony Vegus", software.get(), 7000);

        Tool hardware1 = new Tool("VGA Card", hardware.get(), 10000);
        Tool hardware2 = new Tool("Mainboard", hardware.get(), 3500);
        Tool hardware3 = new Tool("RAM 4GB", hardware.get(), 1500);
        Tool hardware4 = new Tool("RAM 8GB", hardware.get(), 2000);
        Tool hardware5 = new Tool("RAM 16GB", hardware.get(), 3000);
        Tool hardware6 = new Tool("Monitor", hardware.get(), 2500);
        Tool hardware7 = new Tool("Keyboard", hardware.get(), 1000);
        Tool hardware8 = new Tool("Mouse", hardware.get(), 900);
        Tool hardware9 = new Tool("Power Supply", hardware.get(), 2000);
        Tool hardware10 = new Tool("Heat Sink", hardware.get(), 1500);
        Tool hardware11 = new Tool("Harddisk 250GB", hardware.get(), 1500);
        Tool hardware12 = new Tool("Harddisk 500GB", hardware.get(), 3000);
        Tool hardware13 = new Tool("Harddisk 1TB", hardware.get(), 4500);
        Tool hardware14 = new Tool("Harddisk 2TB", hardware.get(), 6000);
        Tool hardware15 = new Tool("Harddisk 3TB", hardware.get(), 9000);
        Tool hardware16 = new Tool("Harddisk 4TB", hardware.get(), 12000);

        toolRepository.save(software1);
        toolRepository.save(software2);
        toolRepository.save(software3);
        toolRepository.save(software4);
        toolRepository.save(software5);
        toolRepository.save(software6);
        toolRepository.save(software7);

        toolRepository.save(hardware1);
        toolRepository.save(hardware2);
        toolRepository.save(hardware3);
        toolRepository.save(hardware4);
        toolRepository.save(hardware5);
        toolRepository.save(hardware6);
        toolRepository.save(hardware7);
        toolRepository.save(hardware8);
        toolRepository.save(hardware9);
        toolRepository.save(hardware10);
        toolRepository.save(hardware11);
        toolRepository.save(hardware12);
        toolRepository.save(hardware13);
        toolRepository.save(hardware14);
        toolRepository.save(hardware15);
        toolRepository.save(hardware16);

    }
}