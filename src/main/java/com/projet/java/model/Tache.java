package com.projet.java.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Date dateEcheance;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "colocation_id")
    private Colocation colocation;

    // getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Date getDateEcheance() {
        return dateEcheance;
    }
    
    public void setDateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
    }
    
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    public Colocation getColocation() {
        return colocation;
    }
    
    public void setColocation(Colocation colocation) {
        this.colocation = colocation;
    }
}
