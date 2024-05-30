package com.projet.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.projet.java.model.Facture;
import com.projet.java.repository.FactureRepository;

import java.util.List;

@Controller
@RequestMapping("/factures")

public class FactureController {
     @Autowired
    private FactureRepository factureRepository;

    @GetMapping
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    @PostMapping
    public Facture createFacture(@RequestBody Facture facture) {
        return factureRepository.save(facture);
    }

    @GetMapping("/{id}")
    public Facture getFactureById(@PathVariable Long id) {
        return factureRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Facture updateFacture(@PathVariable Long id, @RequestBody Facture factureDetails) {
        Facture facture = factureRepository.findById(id).orElseThrow();
        facture.setMontant(factureDetails.getMontant());
        facture.setDateEcheance(factureDetails.getDateEcheance());
        facture.setType(factureDetails.getType());
        return factureRepository.save(facture);
    }

    @DeleteMapping("/{id}")
    public void deleteFacture(@PathVariable Long id) {
        Facture facture = factureRepository.findById(id).orElseThrow();
        factureRepository.delete(facture);
    }
    @GetMapping("/api")
    public String getFacturesPage(Model model) {
        List<Facture> factures = factureRepository.findAll();
        model.addAttribute("factures", factures);
        return "factures"; 
    }
}
