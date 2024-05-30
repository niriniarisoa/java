package com.projet.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import com.projet.java.model.Paiement;
import com.projet.java.repository.PaiementRepository;

import java.util.List;

@Controller
@RequestMapping("/paiement")
public class PaiementController {

    @Autowired
    private PaiementRepository paiementRepository;

    @GetMapping
    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    @PostMapping
    public Paiement createPaiement(@RequestBody Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @GetMapping("/{id}")
    public Paiement getPaiementById(@PathVariable Long id) {
        return paiementRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Paiement updatePaiement(@PathVariable Long id, @RequestBody Paiement paiementDetails) {
        Paiement paiement = paiementRepository.findById(id).orElseThrow();
        paiement.setMontant(paiementDetails.getMontant());
        paiement.setDatePaiement(paiementDetails.getDatePaiement());
        return paiementRepository.save(paiement);
    }

    @DeleteMapping("/{id}")
    public void deletePaiement(@PathVariable Long id) {
        Paiement paiement = paiementRepository.findById(id).orElseThrow();
        paiementRepository.delete(paiement);
    }

    // Nouveau endpoint pour servir le contenu HTML de la page paiements
    @GetMapping("/api")
    public String getPaiementsPage(Model model) {
        List<Paiement> paiements = paiementRepository.findAll();
        model.addAttribute("paiements", paiements);
        return "paiement"; 
    }
}