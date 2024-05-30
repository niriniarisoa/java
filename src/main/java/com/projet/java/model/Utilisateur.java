package com.projet.java.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String phone;
    private String email;
    private String cin;
    @Temporal(TemporalType.DATE)
    private Date dateNais;
    private String mdp;

    @OneToMany(mappedBy = "utilisateur")
    private Set<Paiement> paiements;

    @OneToMany(mappedBy = "utilisateur")
    private Set<Tache> taches;

    @OneToMany(mappedBy = "utilisateur")
    private Set<Facture> factures;

    // getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCin() {
        return cin;
    }
    
    public void setCin(String cin) {
        this.cin = cin;
    }
    
    public Date getDateNais() {
        return dateNais;
    }
    
    public void setDateNais(Date dateNais) {
        this.dateNais = dateNais;
    }
    
    public String getMdp() {
        return mdp;
    }
    
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
    public Set<Paiement> getPaiements() {
        return paiements;
    }
    
    public void setPaiements(Set<Paiement> paiements) {
        this.paiements = paiements;
    }
    
    public Set<Tache> getTaches() {
        return taches;
    }
    
    public void setTaches(Set<Tache> taches) {
        this.taches = taches;
    }
    
    public Set<Facture> getFactures() {
        return factures;
    }
    
    public void setFactures(Set<Facture> factures) {
        this.factures = factures;
    }
}
