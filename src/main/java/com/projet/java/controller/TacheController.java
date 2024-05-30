package com.projet.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import com.projet.java.model.Tache;
import com.projet.java.repository.TacheRepository;

import java.util.List;

@Controller
@RequestMapping("/taches")
public class TacheController {

    @Autowired
    private TacheRepository tacheRepository;

    @GetMapping
    public List<Tache> getAllTaches() {
        return tacheRepository.findAll();
    }

    @PostMapping
    public Tache createTache(@RequestBody Tache tache) {
        return tacheRepository.save(tache);
    }

    @GetMapping("/{id}")
    public Tache getTacheById(@PathVariable Long id) {
        return tacheRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Tache updateTache(@PathVariable Long id, @RequestBody Tache tacheDetails) {
        Tache tache = tacheRepository.findById(id).orElseThrow();
        tache.setDescription(tacheDetails.getDescription());
        tache.setDateEcheance(tacheDetails.getDateEcheance());
        return tacheRepository.save(tache);
    }

    @DeleteMapping("/{id}")
    public void deleteTache(@PathVariable Long id) {
        Tache tache = tacheRepository.findById(id).orElseThrow();
        tacheRepository.delete(tache);
    }

    
    @GetMapping("/api")
    public String getTachesPage(Model model) {
        List<Tache> taches = tacheRepository.findAll();
        model.addAttribute("taches", taches);
        return "taches"; 
    }
    
}