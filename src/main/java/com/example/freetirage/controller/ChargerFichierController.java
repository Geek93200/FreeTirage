package com.example.freetirage.controller;

import com.example.freetirage.model.PostulantTrie;
import com.example.freetirage.service.impl.ChargerFichierService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/file")
public class ChargerFichierController {
    private ChargerFichierService chargerFichierService;

    public ChargerFichierController(ChargerFichierService chargerFichierService) {
        this.chargerFichierService = chargerFichierService;
    }

    @PostMapping()
    public List<PostulantTrie> chargerFichier(@RequestParam ("file") MultipartFile file, @RequestParam("nb_postulant") int nb_postulant) throws IllegalStateException{
       return this.chargerFichierService.chargerFichier(file, nb_postulant);
    }
}
