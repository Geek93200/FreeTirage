package com.example.freetirage.service.impl;

import com.example.freetirage.model.Tirage;
import com.example.freetirage.repository.TirageRepository;
import com.example.freetirage.service.TirageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TirageServiceImpl implements TirageService {

    private TirageRepository tirageRepository;

    public TirageServiceImpl(TirageRepository tirageRepository) {
        this.tirageRepository = tirageRepository;
    }

    @Override
    public Tirage saveTirage(Tirage tirage) {
        return null;
    }

    @Override
    public List<Tirage> listTirage() {
        return this.tirageRepository.findAll();
    }
}
