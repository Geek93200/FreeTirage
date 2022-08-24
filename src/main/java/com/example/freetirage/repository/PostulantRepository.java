package com.example.freetirage.repository;

import com.example.freetirage.model.Postulant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostulantRepository extends JpaRepository<Postulant, Long> {

    public List<Postulant> findByListeId(Long liste_id);
}
