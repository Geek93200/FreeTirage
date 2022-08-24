package com.example.freetirage.repository;

import com.example.freetirage.model.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TirageRepository extends JpaRepository<Tirage, Long> {
}
