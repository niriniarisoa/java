package com.projet.java.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Colocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adresse;

    @OneToMany(mappedBy = "colocation")
    private Set<Facture> factures;

    @OneToMany(mappedBy = "colocation")
    private Set<Tache> taches;

    @OneToMany(mappedBy = "colocation")
    private Set<Paiement> paiements;

    // getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getAdresse() {
        return adresse;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    public Set<Facture> getFactures() {
        return factures;
    }
    
    public void setFactures(Set<Facture> factures) {
        this.factures = factures;
    }
    
    public Set<Tache> getTaches() {
        return taches;
    }
    
    public void setTaches(Set<Tache> taches) {
        this.taches = taches;
    }
    
    public Set<Paiement> getPaiements() {
        return paiements;
    }
    
    public void setPaiements(Set<Paiement> paiements) {
        this.paiements = paiements;
    }
}
