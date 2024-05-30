package com.projet.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projet.java.model.Colocation;

public interface colocationRepository extends JpaRepository<Colocation, Long>{
    
}
