package com.example.freetirage.controller;

import com.example.freetirage.model.PostulantTrie;
import com.example.freetirage.service.impl.PostulantTrieServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/resultat_tirage")
public class PostulantTrieController {
    private PostulantTrieServiceImpl postulantTrieServiceImpl;

    public PostulantTrieController(PostulantTrieServiceImpl postulantTrieServiceImpl) {
        this.postulantTrieServiceImpl = postulantTrieServiceImpl;
    }

    @GetMapping(value = "/{tirage_id}")
    public List<PostulantTrie> getPostulantsByTirage(@PathVariable("tirage_id") long tirage_id){
        return this.postulantTrieServiceImpl.getPostulantsByTirage(tirage_id);
    }

}
