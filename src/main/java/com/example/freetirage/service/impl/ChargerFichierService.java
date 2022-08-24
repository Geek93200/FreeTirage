package com.example.freetirage.service.impl;

import com.example.freetirage.model.Liste;
import com.example.freetirage.model.Postulant;
import com.example.freetirage.model.PostulantTrie;
import com.example.freetirage.model.Tirage;
import com.example.freetirage.repository.ListeRepository;
import com.example.freetirage.repository.PostulantRepository;
import com.example.freetirage.repository.PostulantTrieRepository;
import com.example.freetirage.repository.TirageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class ChargerFichierService {
    PostulantRepository postulantRepository;
    ListeRepository listeRepository;
    PostulantTrieRepository postulantTrieRepository;
    TirageRepository tirageRepository;

    public ChargerFichierService(PostulantRepository postulantRepository, ListeRepository listeRepository, PostulantTrieRepository postulantTrieRepository, TirageRepository tirageRepository) {
        this.postulantRepository = postulantRepository;
        this.listeRepository = listeRepository;
        this.postulantTrieRepository = postulantTrieRepository;
        this.tirageRepository = tirageRepository;
    }

    String line = "";
    public List<PostulantTrie> chargerFichier(MultipartFile file, int nb_postulant) {
        try {
            String filename = "C:\\api_data\\" + file.getOriginalFilename();
            file.transferTo(new File(filename));
            BufferedReader br = new BufferedReader(new FileReader(filename));

            String toDay = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

            //Création de la liste
            Liste liste = new Liste();
            liste.setDate(toDay);
            liste.setLibelle("Liste du " + toDay);
            listeRepository.save(liste);
            //Fin de la création de la liste

            //Parcourir le fichier jusqu'à la derniere ligne
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");

                //Créer un postulant
                Postulant p = new Postulant();
                p.setNom(data[0]);
                p.setPrenom(data[1]);
                p.setNumero(data[2]);
                p.setEmail(data[3]);
                p.setListe(liste);

                postulantRepository.save(p);

                //Fin de la création d'un postulant
            }

            //Création d'un tirage
            Tirage tirage = new Tirage();
            tirage.setDate_tirage(toDay);
            tirage.setLibelle("Tirage du " + toDay);
            tirageRepository.save(tirage);
            //Fin de la création d'un tirage


            //Recuperer les postulants de la liste
            List<Postulant> postulantSet = postulantRepository.findByListeId(liste.getId());

            //Melange la liste pour un tirage aleatoire
            Collections.shuffle(postulantSet);
            List<PostulantTrie> postulantTrieList = new ArrayList<PostulantTrie>();
            for (int i = 0; i <= nb_postulant-1; i++) {
                Postulant po = postulantSet.get(i);
                PostulantTrie postulantTrie = new PostulantTrie();
                postulantTrie.setNom(po.getNom());
                postulantTrie.setPrenom(po.getPrenom());
                postulantTrie.setNumero(po.getNumero());
                postulantTrie.setEmail(po.getEmail());
                postulantTrie.setTirage(tirage);

                postulantTrieList.add(postulantTrie);

                postulantTrieRepository.save(postulantTrie);
            }
            return postulantTrieList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
