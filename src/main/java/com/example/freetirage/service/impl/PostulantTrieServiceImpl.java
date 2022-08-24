package com.example.freetirage.service.impl;

import com.example.freetirage.model.PostulantTrie;
import com.example.freetirage.repository.PostulantTrieRepository;
import com.example.freetirage.service.PostulantTrieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostulantTrieServiceImpl implements PostulantTrieService {
    private PostulantTrieRepository postulantTrieRepository;

    public PostulantTrieServiceImpl(PostulantTrieRepository postulantTrieRepository) {
        this.postulantTrieRepository = postulantTrieRepository;
    }

    @Override
    public PostulantTrie savePostulantTrie(PostulantTrie postulantTrie) {
        return null;
    }

    @Override
    public List<PostulantTrie> getPostulantsByTirage(long tirage_id) {
        return  this.postulantTrieRepository.findByTirageId(tirage_id);
    }
}
