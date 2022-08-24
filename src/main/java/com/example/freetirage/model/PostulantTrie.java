package com.example.freetirage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "postulantrie")
public class PostulantTrie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;
    private String prenom;
    private String numero;
    private String email;

    @ManyToOne
    @JsonIgnore
    private Tirage tirage;
}
