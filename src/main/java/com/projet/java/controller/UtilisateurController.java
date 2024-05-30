package com.projet.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import com.projet.java.model.Utilisateur;
import com.projet.java.repository.UtilisateurRepository;

import java.util.List;

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @PostMapping
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }
    
    @GetMapping("/{id}")
    public Utilisateur getUtilisateurById(@PathVariable Long id) {
        return utilisateurRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Utilisateur updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateurDetails) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElseThrow();
        utilisateur.setNom(utilisateurDetails.getNom());
        utilisateur.setPrenom(utilisateurDetails.getPrenom());
        utilisateur.setPhone(utilisateurDetails.getPhone());
        utilisateur.setEmail(utilisateurDetails.getEmail());
        utilisateur.setCin(utilisateurDetails.getCin());
        utilisateur.setDateNais(utilisateurDetails.getDateNais());
        utilisateur.setMdp(utilisateurDetails.getMdp());
        return utilisateurRepository.save(utilisateur);
    }

    @DeleteMapping("/{id}")
    public void deleteUtilisateur(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElseThrow();
        utilisateurRepository.delete(utilisateur);
    }

    // Nouveau endpoint pour servir le contenu HTML de la page utilisateur
    @GetMapping("/api")
    public String getUserPage(Model model) {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        model.addAttribute("utilisateurs", utilisateurs);
        return "utilisateur"; // Assurez-vous que 'utilisateur' est le nom de votre fichier.html sans l'extension
    }
}
