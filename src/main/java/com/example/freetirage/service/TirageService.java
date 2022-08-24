package com.example.freetirage.service;

import com.example.freetirage.model.Postulant;
import com.example.freetirage.model.Tirage;

import java.util.List;

public interface TirageService {
    Tirage saveTirage(Tirage tirage);

    List<Tirage> listTirage();
}
