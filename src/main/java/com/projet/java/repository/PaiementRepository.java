package com.projet.java.repository;

import com.projet.java.model.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement, Long>{
    
}
