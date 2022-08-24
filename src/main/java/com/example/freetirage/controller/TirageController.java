package com.example.freetirage.controller;

import com.example.freetirage.model.Tirage;
import com.example.freetirage.service.impl.TirageServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tirages")
public class TirageController {
    TirageServiceImpl tirageService;

    public TirageController(TirageServiceImpl tirageService) {
        this.tirageService = tirageService;
    }

    @GetMapping
    public List<Tirage> getAll(){
        return this.tirageService.listTirage();
    }
}
