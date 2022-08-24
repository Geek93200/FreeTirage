package com.example.freetirage.service.impl;

import com.example.freetirage.model.Postulant;
import com.example.freetirage.repository.PostulantRepository;
import com.example.freetirage.service.PostulantService;
import org.springframework.stereotype.Service;

@Service
public class PostulantServiceImpl implements PostulantService {
    private PostulantRepository postulantRepository;

    @Override
    public Postulant savePostulant(Postulant postulant) {
        return null;
    }
}
