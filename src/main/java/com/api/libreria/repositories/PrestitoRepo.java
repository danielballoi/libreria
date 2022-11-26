package com.api.libreria.repositories;

import com.api.libreria.entities.Prestito;
import com.api.libreria.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestitoRepo extends JpaRepository<Prestito, Long> {

    List<Prestito> findAllByUtente(Utente utente);

}
