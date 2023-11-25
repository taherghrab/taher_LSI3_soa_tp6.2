package org.example.repositories;

import org.example.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

// Extending JpaRepository to inherit generic CRUD methods for the 'Compte' entity
// @Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
}

