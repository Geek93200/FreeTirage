package com.example.freetirage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tirage")
public class Tirage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String libelle;
    private String date_tirage;

    @OneToMany(mappedBy = "tirage")
    @JsonIgnore
    private Set<PostulantTrie> postulantTries = new HashSet<>();
}
