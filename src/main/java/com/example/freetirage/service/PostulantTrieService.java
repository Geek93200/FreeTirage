package com.example.freetirage.service;

import com.example.freetirage.model.PostulantTrie;

import java.util.List;

public interface PostulantTrieService {
    PostulantTrie savePostulantTrie(PostulantTrie postulantTrie);
    List<PostulantTrie> getPostulantsByTirage(long tirage_id);
}
