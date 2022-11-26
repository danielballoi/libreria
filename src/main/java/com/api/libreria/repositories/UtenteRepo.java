package com.api.libreria.repositories;

import com.api.libreria.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Long> {
    List<Utente> findAllByOrderByName();
}
