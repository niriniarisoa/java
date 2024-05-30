package com.projet.java.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double montant;
    private Date dateEcheance;
    private String type;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "colocation_id")
    private Colocation colocation;

    @OneToMany(mappedBy = "facture")
    private Set<Paiement> paiements;

    // getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Double getMontant() {
        return montant;
    }
    
    public void setMontant(Double montant) {
        this.montant = montant;
    }
    
    public Date getDateEcheance() {
        return dateEcheance;
    }
    
    public void setDateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
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
    
    public Set<Paiement> getPaiements() {
        return paiements;
    }
    
    public void setPaiements(Set<Paiement> paiements) {
        this.paiements = paiements;
    }
}
