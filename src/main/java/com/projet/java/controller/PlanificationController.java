package com.projet.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import com.projet.java.model.Tache;
import com.projet.java.repository.TacheRepository;

import java.util.Date;

@Controller
@RequestMapping("/planification")
public class PlanificationController {
    @Autowired
    private TacheRepository tacheRepository;

    @GetMapping
    public String showPlanificationForm() {
        return "planification"; // Nom de la vue sans l'extension.html
    }

    @PostMapping("/addTask")
    public String addTask(@RequestParam("description") String description,
                          @RequestParam("dateEcheance") Date dateEcheance,
                          Model model) {
        Tache tache = new Tache();
        tache.setDescription(description);
        tache.setDateEcheance(dateEcheance);

        // Supposons que vous avez un utilisateur connecté et une colocation sélectionnée
        // tache.setUtilisateur(utilisateur);
        // tache.setColocation(colocation);

        tacheRepository.save(tache);
        return "redirect:/planification"; // Redirige vers la page de planification après l'ajout
    }
}
