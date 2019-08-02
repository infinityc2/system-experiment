package com.example.sa.controller;

import java.util.List;

import com.example.sa.entity.Tool;
import com.example.sa.entity.ToolType;
import com.example.sa.repository.ToolRepository;
import com.example.sa.repository.ToolTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tool")
@CrossOrigin(origins = "*")
public class ToolController {
    
    @Autowired private ToolRepository toolRepository;
    @Autowired private ToolTypeRepository toolTypeRepository;

    @GetMapping()
    public List<Tool> tools() {
        return toolRepository.findAll();
    }

    @GetMapping("/type")
    public List<ToolType> toolTypes() {
        return toolTypeRepository.findAll();
    }

}