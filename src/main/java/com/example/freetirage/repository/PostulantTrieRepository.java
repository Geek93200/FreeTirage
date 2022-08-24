package com.example.freetirage.repository;

import com.example.freetirage.model.PostulantTrie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostulantTrieRepository extends JpaRepository<PostulantTrie, Long> {
    List<PostulantTrie> findByTirageId(long tirage_id);
}
