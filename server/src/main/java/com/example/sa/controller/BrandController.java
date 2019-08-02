package com.example.sa.controller;

import java.util.List;

import com.example.sa.entity.Brand;
import com.example.sa.entity.ComputerType;
import com.example.sa.repository.BrandRepository;
import com.example.sa.repository.ComputerTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/computer")
@CrossOrigin(origins = "*")
public class BrandController {

    @Autowired private BrandRepository brandRepository;
    @Autowired private ComputerTypeRepository computerTypeRepository;

    @GetMapping("/brand")
    public List<Brand> brands() {
        return brandRepository.findAll();
    }    

    @GetMapping("/type")
    public List<ComputerType> computerTypes() {
        return computerTypeRepository.findAll();
    }
}